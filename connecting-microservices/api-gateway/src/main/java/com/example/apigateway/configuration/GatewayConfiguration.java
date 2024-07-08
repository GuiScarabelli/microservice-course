package com.example.apigateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class GatewayConfiguration {

  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

    // Get the path and redirect to another URL
    return builder.routes()
            .route(p -> p.path("/get")
                    .filters(f -> f
                            .addRequestHeader("hello", "world")
                            .addRequestParameter("hello", "world"))
                    .uri("http://httpbin.org:80"))// Default Spring URI, this convert a HTTP call to a JSON

            .route(p -> p.path("/exchanges/**")
                    .uri("lb://cambio-service"))

            .route(p -> p.path("/books/**")
                    .uri("lb://book-service"))
            .build();
  }
}
