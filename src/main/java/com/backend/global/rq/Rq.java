package com.backend.global.rq;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseCookie;
import com.backend.global.app.AppConfig;

@Service
public class Rq {

  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;
  }

  private String cookieDomain() {
    String domain = AppConfig.getSiteCookieDomain();
    return "localhost".equals(domain) ? domain : "." + domain;
  }

  public void setCookie(String name, String value) {
    ResponseCookie cookie = ResponseCookie.from(name, value)
        .path("/")
        .domain(cookieDomain())
        .sameSite("Strict")
        .secure(true)
        .httpOnly(true)
        .build();
    resp.addHeader("Set-Cookie", cookie.toString());
  }

  public String getCookieValue(String name) {
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(name)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }

  public void deleteCookie(String name) {
    ResponseCookie cookie = ResponseCookie.from(name, "")
        .path("/")
        .domain("localhost")
        .sameSite("Strict")
        .secure(true)
        .httpOnly(true)
        .maxAge(0)
        .build();
    resp.addHeader("Set-Cookie", cookie.toString());
  }

  public void setHeader(String name, String value) {
    resp.setHeader(name, value);
  }

  public String getHeader(String name) {
    return req.getHeader(name);
  }

  public void setSession(String name, String value) {
    req.getSession().setAttribute(name, value);
  }

  public String getSessionValueAsStr(String name) {
    Object obj = req.getSession().getAttribute(name);
    return obj instanceof String ? (String) obj : null;
  }
}
