package com.ing.training.com.ing.training.math;

import com.ing.training.math.CurrencyUnit;
import com.ing.training.math.Exchange;
import com.ing.training.math.ExchangeRate;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Currency;

public class ExchangeTest {

    private final String EUR_DEM_RATE = "1,9558";

    @Test
    public void exchange_class_and_dependencies_should_exist() {
        // arrange

        // act
        new Exchange(Currency.getInstance("EUR"), Currency.getInstance("DEM"), new ExchangeRate(EUR_DEM_RATE));

        // assert
    }

    @Test
    public void exchange_from_euro_to_dem() throws Exception {
        // arrange
        CurrencyUnit eur = new CurrencyUnit("10,00 EUR");
        CurrencyUnit dem = new CurrencyUnit("19,56 DEM");

        Currency fromCurrency = Currency.getInstance("EUR");
        Currency toCurrency = Currency.getInstance("DEM");
        ExchangeRate exchangeRate = new ExchangeRate(EUR_DEM_RATE);
        Exchange exchange = new Exchange(fromCurrency, toCurrency, exchangeRate);

        // act
        CurrencyUnit result = eur.exchangeTo(exchange);

        // assert
        Assert.assertEquals(dem, result);
    }
}
