package com.example.cambioservice.mapper;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExchangeListing {

  private String from;

  private String to;

  private Double conversionFactor;

  private Double conversionValue;
}
