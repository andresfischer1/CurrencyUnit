package com.ing.training.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyUnit {

    private static final String READ_PATTERN = "#.##";
    private static final Pattern PATTERN = Pattern.compile("((\\d|\\.)*\\d(,)?(\\d+)*)( )*(€|\\$|\\w{3})");

    private final BigDecimal value;
    private final Currency currency;

    public CurrencyUnit(final String currencyUnitAsText) throws Exception {
        currency = extractCurrency(currencyUnitAsText);
        value = extractValue(currencyUnitAsText);
    }

    public CurrencyUnit(final BigDecimal currencyUnit) {
        this(currencyUnit, Currency.getInstance("EUR"));
    }

    public CurrencyUnit(BigDecimal value, Currency currency) {
        this.currency = currency;
        this.value = value.setScale(this.currency.getDefaultFractionDigits(), RoundingMode.HALF_UP);;
    }

    private BigDecimal parseCurrencyUnit(String currencyUnitAsText) throws ParseException {
        DecimalFormat df = new DecimalFormat(READ_PATTERN);
        df.setParseBigDecimal(true);
        return (BigDecimal) df.parse(currencyUnitAsText);
    }

    private BigDecimal extractValue(String currencyUnitAsText) throws Exception {
        final Matcher matcher = PATTERN.matcher(currencyUnitAsText);
        if (matcher.find()) {
            return parseCurrencyUnit(matcher.group(1)).setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_UP);
        }
        throw new Exception("Keine gültige Zahl!");
    }

    private Currency extractCurrency(String currencyUnitAsText) {
        final Matcher matcher = PATTERN.matcher(currencyUnitAsText);
        if (matcher.find()) {
            String currencyCode = "";
            try {
                currencyCode = replaceCurrencySymbolByIsoCode(matcher.group(6));
                return Currency.getInstance(currencyCode);
            } catch (IllegalArgumentException e) {
                throw new WrongCurrencyException("Die Währung " + currencyCode + " ist ungültig!", e);
            }
        }
        return null;
    }

    private String replaceCurrencySymbolByIsoCode(String currencySymbol) {
        if (currencySymbol.equals("€")) {
            return "EUR";
        }
        if (currencySymbol.equals("$")) {
            return "USD";
        } else
            return currencySymbol;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    private String buildWritePattern() {
        String writePattern = "#,###";
        if (currency.getDefaultFractionDigits() > 0) {
            writePattern += "." + repeatString(currency.getDefaultFractionDigits(), "0");
        }
        return writePattern;
    }

    private String repeatString(int number, String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append(text);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return new DecimalFormat(buildWritePattern()).format(value) + " " + currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyUnit that = (CurrencyUnit) o;
        return Objects.equals(value, that.value) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    public CurrencyUnit multiply(Percent percent) {
        BigDecimal currencyUnit = value.multiply(percent.getAsBigDecimal());
        return new CurrencyUnit(currencyUnit, currency);
    }

    public CurrencyUnit exchangeTo(Exchange exchange) throws Exception {
        if (!currency.equals(exchange.getFromCurrency())) {
            throw new Exception("Währungsbetrag ist in " + currency + ", aber Wechselkurs in " + exchange.getFromCurrency());
        }
        Currency newCurreny = exchange.getToCurrency();
        BigDecimal newValue = value.multiply(exchange.getExchangeRate().getValue());
        return new CurrencyUnit(newValue, newCurreny);
    }

}
