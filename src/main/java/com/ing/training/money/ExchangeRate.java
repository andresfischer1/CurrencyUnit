package com.ing.training.money;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class ExchangeRate {

    private final BigDecimal value;

    public ExchangeRate(String exchangeAsText) throws ParseException {
        DecimalFormat df = new DecimalFormat();
        df.setParseBigDecimal(true);
        value = (BigDecimal) df.parse(exchangeAsText);
    }

    public BigDecimal getValue() {
        return value;
    }
}
