package com.example.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookDontExist extends RuntimeException {
    public BookDontExist(String message) {
      super(message);
    }
}
