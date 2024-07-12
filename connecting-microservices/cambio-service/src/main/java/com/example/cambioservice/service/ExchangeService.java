package com.example.cambioservice.service;

import com.example.cambioservice.entity.Exchange;
import com.example.cambioservice.exception.ExchangeDontExist;
import com.example.cambioservice.repository.ExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
  @Autowired
  private Environment environment;// Serve para recuperar a porta da instancia do cambio-service

  @Autowired
  private ExchangeRepository repository;
  private Logger logger = LoggerFactory.getLogger(ExchangeService.class);

  public Exchange getExchange(String to, String from, Double amount){

    logger.info("getExchange is called with -> {}, {} and {}", amount, from, to);
    var cambio = repository.findByFromAndTo(from, to);
    if(cambio == null){
      throw new ExchangeDontExist("Exchange not found for the provided currency pair.");
    }

    Double conversionFactor = cambio.getConversionFactor();
    Double convertedValue = Math.ceil(conversionFactor * amount * 100.0) / 100.0;

    cambio.setConversionValue(convertedValue);
    return cambio;
  }
}


