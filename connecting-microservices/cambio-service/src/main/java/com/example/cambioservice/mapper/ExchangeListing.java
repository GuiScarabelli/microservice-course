package com.example.cambioservice.mapper;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ExchangeListing {

  private String from;

  private String to;

  private Double conversionFactor;

  private Double conversionValue;
}
