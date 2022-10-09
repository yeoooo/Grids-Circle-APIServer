package com.example.gccoffee.Exception;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String cause, String message) {
        super(cause+"의 "+message);

    }
}
