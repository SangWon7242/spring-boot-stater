package com.backend.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "home/index"; // Changed from "home" to "home/index"
  }
}