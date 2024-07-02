package com.example.cambioservice.controller;

import com.example.cambioservice.entity.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

  @Autowired
  private Environment environment;// Serve para recuperar a porta da instancia do cambio-service

  @GetMapping("/{amount}/{from}/{to}")
  private Exchange getExchange(@PathVariable BigDecimal amount,
                               @PathVariable String from,
                               @PathVariable String to ){

    String port = environment.getProperty("local.server.port");
    return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
  }
}
