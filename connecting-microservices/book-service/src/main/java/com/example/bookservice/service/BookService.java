package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.exception.BookDontExist;
import com.example.bookservice.proxy.ExchangeProxy;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  @Autowired
  private ExchangeProxy proxy;

  @Autowired
  private Environment port;

  public Book getBookById(Integer id, String currency){
    Optional<Book> bookOpt = repository.findById(id);
    if (bookOpt.isEmpty()){
      throw new BookDontExist("This book id doesn't exists!");
    }

    var environment = port.getProperty("local.server.port");
    var exchange = proxy.getExchange(bookOpt.get().getPrice(), "USD", currency);
    bookOpt.get().setPrice(Objects.requireNonNull(exchange.getBody()).getConversionValue());

    bookOpt.get().setEnviroment(environment);

    return bookOpt.get();
  }
}
