package com.example.bookservice.controller;

import com.example.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private Environment environment;

  @GetMapping("/{id}/{currency}")
  public Book getBook(@PathVariable int id, @PathVariable String currency){
    var port = environment.getProperty("local.server.port");

    return new Book(1, "Autor Livro", LocalDate.of(2000, 10, 10)  ,10.0, "Teste test", currency, port);
  }
}
