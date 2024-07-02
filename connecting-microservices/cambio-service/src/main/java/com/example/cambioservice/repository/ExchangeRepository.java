package com.example.cambioservice.repository;

import com.example.cambioservice.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
  Exchange findByFromAndTo(String from, String to);
}
