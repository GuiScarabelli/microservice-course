package com.example.bookservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/foo-bar")
public class FooBarController {

  private Logger logger = LoggerFactory.getLogger(FooBarController.class);

  @GetMapping
  // Annotation to retry the request, can be customized in application.yml
  @Retry(name = "default")
  public String fooBar(){
    logger.info("Request to foo-bar is received!");
    var response = new RestTemplate()
            .getForEntity("http://localhost:8080/foo-bar", String.class);
    return response.getBody();
  }

}
