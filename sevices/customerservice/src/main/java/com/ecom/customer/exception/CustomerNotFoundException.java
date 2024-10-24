package com.ecom.customer.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
