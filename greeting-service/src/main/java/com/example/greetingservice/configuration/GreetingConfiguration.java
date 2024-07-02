package com.example.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope //
@ConfigurationProperties("greeting-service") //Faz a relação entre o arquivo de conexão e a classe java
public class GreetingConfiguration {
  private String greeting;
  private String defaultValue;

  public GreetingConfiguration() {}

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
}
