package com.eduardorasgado.junit5application.examples.exceptions;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
