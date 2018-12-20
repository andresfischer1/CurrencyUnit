package com.ing.training.money;

public class WrongCurrencyException extends RuntimeException {

    public WrongCurrencyException(String message, Exception exception) {
        super(message, exception);
    }
}
