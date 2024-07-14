package com.example.cambioservice.controller;

import com.example.cambioservice.entity.Exchange;
import com.example.cambioservice.mapper.ExchangeListing;
import com.example.cambioservice.mapper.ExchangeMapper;
import com.example.cambioservice.repository.ExchangeRepository;
import com.example.cambioservice.service.ExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@Tag(name = "Exchange endpoint")
@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

  @Autowired
  private ExchangeService service;

  @Operation(summary = "Get the exchange from the currency")
  @GetMapping("/{amount}/{from}/{to}")
  private ResponseEntity<ExchangeListing> getExchange(@PathVariable Double amount,
                                                      @PathVariable String from,
                                                      @PathVariable String to ){

    Exchange exchange = service.getExchange(to, from, amount);
    ExchangeListing dto = ExchangeMapper.toDto(exchange);

    return ResponseEntity.status(200).body(dto);
  }
}
