package com.example.gccoffee.Exception;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
    }

    public NoSuchProductException(String message) {
        super(message);
    }
}
