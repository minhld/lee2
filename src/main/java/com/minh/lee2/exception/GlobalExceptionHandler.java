package com.minh.lee2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerNotFound() {
        ErrorMessage error = ErrorMessage.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message("Customer Not Found")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
