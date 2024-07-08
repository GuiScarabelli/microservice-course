package com.example.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
public class FooBarController {

  private Logger logger = LoggerFactory.getLogger(FooBarController.class);

  @GetMapping("/foo-bar")

  // Annotation to retry the request, can be customized in application.yml
  // @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod") // Determine how many times it's going to request
  // @CircuitBreaker(name = "foo-bar", fallbackMethod = "fallbackMethod")
  // @RateLimiter(name = "foo-bar") // Determine the number of requests

  @Bulkhead(name = "default") // determmine how many concurrent-calls
  public String fooBar(){
    logger.info("Request to foo-bar is received!");
    //var response = new RestTemplate()
    //        .getForEntity("http://localhost:8080/foo-bar", String.class);
    //return response.getBody();
    return "foo-bar";
  }

  public String fallbackMethod(Exception ex){
    return "fallback method!!!";
  }
}
