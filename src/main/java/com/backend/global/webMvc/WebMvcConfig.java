package com.backend.global.webMvc;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.backend.global.app.AppConfig;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String genFileDirPath = AppConfig.getGenFileDirPath();
    String resourceLocation = Paths.get(genFileDirPath)
        .toUri()
        .toString()
        .replace("file:/", "file:///");

    registry.addResourceHandler("/gen/**")
        .addResourceLocations(resourceLocation);
  }
}
