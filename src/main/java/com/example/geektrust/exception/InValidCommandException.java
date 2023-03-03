package com.example.geektrust.exception;

public class InValidCommandException extends RuntimeException {
    public InValidCommandException() {
    }

    public InValidCommandException(String message) {
        super(message);
    }
}
