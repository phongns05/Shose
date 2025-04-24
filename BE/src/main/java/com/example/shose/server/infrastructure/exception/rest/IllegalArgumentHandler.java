package com.example.shose.server.infrastructure.exception.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class IllegalArgumentHandler extends ShoseExceptionRestHandler<IllegalArgumentException> {

    @Override
    protected Object wrapApi(IllegalArgumentException ex) {
        return Map.of("error", "Illegal argument", "message", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleException(IllegalArgumentException ex) {
        return handle(ex); // gọi lại phương thức trong abstract class
    }
}
