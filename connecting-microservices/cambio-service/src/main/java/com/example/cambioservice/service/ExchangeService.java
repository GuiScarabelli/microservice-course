package com.example.cambioservice.service;

import com.example.cambioservice.entity.Exchange;
import com.example.cambioservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeService {
  @Autowired
  private Environment environment;// Serve para recuperar a porta da instancia do cambio-service

  @Autowired
  private ExchangeRepository repository;

  public Exchange getExchange(String to, String from, BigDecimal amount){

      var cambio = repository.findByFromAndTo(from, to);
      String port = environment.getProperty("local.server.port");

      BigDecimal conversionFactor = cambio.getConversionFactor();
      BigDecimal convertedValue = conversionFactor.multiply(amount);

      cambio.setConversionValue(convertedValue.setScale(2, RoundingMode.CEILING));
      cambio.setEnviroment(port);

      return cambio;
  }
}
