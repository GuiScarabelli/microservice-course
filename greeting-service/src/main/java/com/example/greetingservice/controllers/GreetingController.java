package com.example.greetingservice.controllers;

import com.example.greetingservice.configuration.GreetingConfiguration;
import com.example.greetingservice.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  private static final String template = "%s %s";

  @Autowired
  private GreetingConfiguration configuration;

  @RequestMapping("/greetings")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
    if(name.isEmpty()){
      name = configuration.getDefaultValue();
    }


     return new Greeting(1, String.format(template, configuration.getGreeting(), name));
  }
}
