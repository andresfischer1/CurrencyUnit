package com.ing.training.money;

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

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
}
