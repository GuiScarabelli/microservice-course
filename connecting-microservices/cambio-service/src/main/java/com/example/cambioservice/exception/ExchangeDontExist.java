package com.example.cambioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ExchangeDontExist extends RuntimeException {
    public ExchangeDontExist(String message) {
      super(message);
    }
}
