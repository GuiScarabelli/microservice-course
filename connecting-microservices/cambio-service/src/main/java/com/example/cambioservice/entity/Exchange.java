package com.example.cambioservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Exchange {
  private Long id;

  private String from;

  private String to;

  private BigDecimal conversionFactor;

  private BigDecimal conversionValue;

  private String enviroment;
}
