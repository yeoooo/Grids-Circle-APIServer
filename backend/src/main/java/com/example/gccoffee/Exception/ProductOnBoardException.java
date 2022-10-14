package com.example.gccoffee.Exception;

public class ProductOnBoardException extends RuntimeException{
    public ProductOnBoardException() {
        super();
    }

    public ProductOnBoardException(String message) {
        super(message);
    }
}
