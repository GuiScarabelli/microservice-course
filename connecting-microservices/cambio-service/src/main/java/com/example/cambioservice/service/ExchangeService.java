package com.example.cambioservice.service;

import com.example.cambioservice.entity.Exchange;
import com.example.cambioservice.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
  @Autowired
  private Environment environment;// Serve para recuperar a porta da instancia do cambio-service

  @Autowired
  private ExchangeRepository repository;
  public Exchange getExchange(String to, String from, Double amount){

    var cambio = repository.findByFromAndTo(from, to);

    Double conversionFactor = cambio.getConversionFactor();
    Double convertedValue = Math.ceil(conversionFactor * amount * 100.0) / 100.0;

    cambio.setConversionValue(convertedValue);
    return cambio;
  }
}
