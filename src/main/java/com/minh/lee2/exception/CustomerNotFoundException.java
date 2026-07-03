package com.minh.lee2.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id) {
        super("Customer with ID " + id + " not found");
    }
}
