package com.example.bookservice.response;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Exchange {
  private Long id;

  private String from;

  private String to;

  private Double conversionFactor;

  private Double conversionValue;

  private String enviroment;
}
