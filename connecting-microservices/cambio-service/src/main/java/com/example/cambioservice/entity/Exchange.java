package com.example.cambioservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
// @Entity
public class Exchange {
  /*@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   */
  private Long id;


  private String from;

  private String to;

  private BigDecimal conversionFactor;

  private BigDecimal conversionValue;

  private String enviroment;
}
