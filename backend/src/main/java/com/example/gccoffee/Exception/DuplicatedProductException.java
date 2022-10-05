package com.example.gccoffee.Exception;

public class DuplicatedProductException extends RuntimeException{
    public DuplicatedProductException() {
        super();
    }

    public DuplicatedProductException(String message) {
        super(message);
    }
}
