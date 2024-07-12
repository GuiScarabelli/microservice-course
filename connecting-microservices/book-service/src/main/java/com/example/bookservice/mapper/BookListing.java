package com.example.bookservice.mapper;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class BookListing {
  private String author;
  private LocalDate launchDate;
  private Double price;
  private String title;
  private String environment;
}
