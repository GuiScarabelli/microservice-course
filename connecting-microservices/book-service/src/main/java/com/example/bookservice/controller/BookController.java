package com.example.bookservice.controller;

import com.example.bookservice.entity.Book;
import com.example.bookservice.mapper.BookListing;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService service;

  @GetMapping("/{id}/{currency}")
  public ResponseEntity<BookListing> getBook(@PathVariable int id, @PathVariable String currency){
    Book book = service.getBookById(id);
    BookListing bookdto = BookMapper.toDto(book);

    return ResponseEntity.status(200).body(bookdto);
  }
}
