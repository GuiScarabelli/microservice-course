package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.exception.BookDontExist;
import com.example.bookservice.proxy.ExchangeProxy;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.response.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  @Autowired
  private ExchangeProxy proxy;

  public Book getBookById(Integer id, String currency){
    Optional<Book> bookOpt = repository.findById(id);
    if (bookOpt.isEmpty()){
      throw new BookDontExist("This book id doesn't exists!");
    }

    var exchange = proxy.getExchange(bookOpt.get().getPrice(), "USD", currency);
    bookOpt.get().setPrice(Objects.requireNonNull(exchange.getBody()).getConversionValue());

    return bookOpt.get();
  }
}
