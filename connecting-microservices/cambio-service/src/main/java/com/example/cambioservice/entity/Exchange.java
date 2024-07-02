package com.example.cambioservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Exchange {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_currency")
  private String from;

  @Column(name = "to_currency")
  private String to;

  private BigDecimal conversionFactor;

  private BigDecimal conversionValue;

  private String enviroment;
}
