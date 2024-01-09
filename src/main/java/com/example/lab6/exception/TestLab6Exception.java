package com.example.lab6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TestLab6Exception extends RuntimeException{

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "ERROR")
    @ExceptionHandler(NullPointerException.class)
    public void myException(String message) {

        System.out.println(message);
    }
}
