package com.example.bookservice.proxy;

import com.example.bookservice.exchangeResponse.mapper.ExchangeListing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Aqui ele vai buscar o serviço utilizando o Feign
@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface ExchangeProxy {

  @GetMapping("exchanges/{amount}/{from}/{to}")
  public ResponseEntity<ExchangeListing> getExchange(@PathVariable Double amount,
                               @PathVariable String from,
                               @PathVariable String to);
}
