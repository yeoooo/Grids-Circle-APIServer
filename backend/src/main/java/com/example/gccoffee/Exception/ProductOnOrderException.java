package com.example.gccoffee.Exception;

public class ProductOnOrderException extends RuntimeException{
    public ProductOnOrderException() {
        super();
    }

    public ProductOnOrderException(String message) {
        super(message);
    }
}
