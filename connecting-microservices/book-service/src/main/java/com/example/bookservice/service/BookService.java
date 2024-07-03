package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookService {
  @Autowired
  private BookRepository repository;

  public Book getBookById(Integer id){
    Optional<Book> bookOpt = repository.findById(id);
    if (bookOpt.isEmpty()){
      throw new ResponseStatusException(
              HttpStatus.NOT_FOUND
      );
    }
    return bookOpt.get();
  }
}
