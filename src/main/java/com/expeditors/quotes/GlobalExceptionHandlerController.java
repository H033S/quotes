package com.expeditors.quotes;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    public static final Logger logger = LoggerFactory.getLogger(
            GlobalExceptionHandlerController.class);

    @ExceptionHandler(QuoteIndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExceptions(
            QuoteIndexOutOfBoundsException exception) {

        return "RestControllerAdvice";
    }

}
