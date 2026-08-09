package com.minh.lee2.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String firstName) {
        super("Customer with first name " + firstName + " not found");
    }
}
