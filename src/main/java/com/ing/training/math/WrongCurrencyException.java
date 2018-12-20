package com.ing.training.math;

public class WrongCurrencyException extends RuntimeException {

    public WrongCurrencyException(String message, Exception exception) {
        super(message, exception);
    }
}
