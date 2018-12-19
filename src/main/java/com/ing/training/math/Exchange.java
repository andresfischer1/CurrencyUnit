package com.ing.training.math;

import java.util.Currency;

public class Exchange {

    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final ExchangeRate exchangeRate;

    public Exchange(Currency fromCurrency, Currency toCurrency, ExchangeRate exchangeRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeRate = exchangeRate;
    }

}
