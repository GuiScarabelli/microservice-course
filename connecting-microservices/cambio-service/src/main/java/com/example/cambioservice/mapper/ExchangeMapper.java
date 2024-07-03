package com.example.cambioservice.mapper;

import com.example.cambioservice.entity.Exchange;

import java.util.List;
import java.util.Objects;

public class ExchangeMapper {
  public static ExchangeListing toDto(Exchange entity) {
    if (entity == null) {
      return null;
    }

    ExchangeListing dto = new ExchangeListing();
    dto.setTo(entity.getTo());
    dto.setFrom(entity.getFrom());
    dto.setConversionFactor(entity.getConversionFactor());
    dto.setConvertedValue(entity.getConversionValue());
    return dto;
  }

  public static List<ExchangeListing> toDto(List<Exchange> entities) {
    return entities.stream().map(ExchangeMapper::toDto).toList();
  }

/*
  public static Exchange toEntity(ExchangeListing dto) {
    Exchange exchange = new Exchange();

    exchange.setNome(dto.getNome());
    exchange.setDescricao(dto.getDescricao());
    exchange.setPrioridade(dto.getPrioridade());

    return exchange;
  }
 */
}
