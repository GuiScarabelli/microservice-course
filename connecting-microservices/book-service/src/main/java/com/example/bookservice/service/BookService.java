package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.exception.BookDontExist;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.response.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository repository;

  public Book getBookById(Integer id, String currency){
    Optional<Book> bookOpt = repository.findById(id);
    if (bookOpt.isEmpty()){
      throw new BookDontExist("This book id doesn't exists!");
    }

    HashMap<String, String> params = new HashMap<>();
    params.put("amount", bookOpt.get().getPrice().toString());
    params.put("from", "USD");
    params.put("to", currency);


    //It's going to consume the exchange service using restTemplate
    var response = new RestTemplate()
            .getForEntity("http://localhost:8000/exchanges/{amount}/{from}/{to}",
                    Exchange.class,
                    params);
    var exchange = response.getBody();

    if (exchange != null) {
      bookOpt.get().setPrice(exchange.getConversionValue());
    }

    return bookOpt.get();
  }
}
