package com.example.gccoffee.Exception;

public class NoSuchOrderException extends RuntimeException{

    public NoSuchOrderException() {
        super();
    }

    public NoSuchOrderException(String message) {
        super(message);
    }
}
