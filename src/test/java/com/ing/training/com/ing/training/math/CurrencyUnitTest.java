package com.ing.training.com.ing.training.math;

import com.ing.training.math.CurrencyUnit;
import com.ing.training.math.Percent;
import com.ing.training.math.WrongCurrencyException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.Assert.assertEquals;

public class CurrencyUnitTest {

    @Test
    public void currency_Unit_class_should_exist () throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("17,00€" );

        //arrange
        assertEquals(new BigDecimal("17.00"), currencyUnit.getValue());

    }

    @Test
    public void currency_Unit_class_should_be_normalized () throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("17€" );

        //arrange
        assertEquals(new BigDecimal("17.00"), currencyUnit.getValue());
    }

    @Test
    public void currency_Unit_class_from_string_should_be_normalized_and_rounded () throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("17,3789123€" );

        //arrange
        assertEquals(new BigDecimal("17.38"), currencyUnit.getValue());
    }

    @Test
    public void currency_Unit_class_from_bigdecimal_should_be_normalized () throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit(new BigDecimal("12") );

        //arrange
        assertEquals(new BigDecimal("12.00"), currencyUnit.getValue());
    }

    @Test
    public void currency_Unit_class_from_bigdecimal_should_be_normalized_and_rounded () throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit(new BigDecimal("12.34567") );

        //arrange
        assertEquals(new BigDecimal("12.35"), currencyUnit.getValue());
    }

    @Test
    public void currency_Unit_class_should_have_a_toString_method() throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("17€" );

        //arrange
        assertEquals("17,00 EUR", currencyUnit.toString());
    }

    @Test
    public void currency_Unit_class_should_have_a_toString_method_with_decimal_separator() throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("1700€" );

        //arrange
        assertEquals("1.700,00 EUR", currencyUnit.toString());
    }

    @Test
    public void currency_Unit_class_should_have_a_toString_method_with_decimal_separator_for_millions() throws Exception {
        //arrange

        //act
        CurrencyUnit currencyUnit = new CurrencyUnit("1700000€" );

        //arrange
        assertEquals("1.700.000,00 EUR", currencyUnit.toString());
    }

    @Test
    public void currencyUnit_should_implement_equals_and_hashcode() throws Exception {
        // arrange
        CurrencyUnit oneEuro = new CurrencyUnit("1€");
        CurrencyUnit anotherOneEuro = new CurrencyUnit("1,00€");

        // act + assert
        assertEquals(oneEuro, anotherOneEuro);
    }


}

    @Test
    public void currencyUnit_with_euro_symbol_should_return_the_correct_currency() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("100,47€");

        // assert
        assertEquals(new BigDecimal("100.47"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("EUR"), currencyUnit.getCurrency());
    }

    @Test
    public void currencyUnit_with_USD_should_return_the_correct_currency() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("123,47$");

        // assert
        assertEquals(new BigDecimal("123.47"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("USD"), currencyUnit.getCurrency());
        assertEquals("123,47 USD", currencyUnit.toString());
    }

    @Test
    public void currencyUnit_should_work_with_EUR() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("2343,47 EUR");

        // assert
        assertEquals(new BigDecimal("2343.47"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("EUR"), currencyUnit.getCurrency());
        assertEquals("2.343,47 EUR", currencyUnit.toString());
    }

    @Test
    public void currencyUnit_should_work_with_JPY() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("43218768 JPY");

        // assert
        assertEquals(new BigDecimal("43218768"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("JPY"), currencyUnit.getCurrency());
        assertEquals("43.218.768 JPY", currencyUnit.toString());
    }

    @Test
    public void currencyUnit_without_fraction_should_not_work() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("0,01 JPY");

        // assert
        assertEquals(new BigDecimal("0"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("JPY"), currencyUnit.getCurrency());
        assertEquals("0 JPY", currencyUnit.toString());
    }

    @Test(expected = WrongCurrencyException.class)
    public void currencyUnit_should_note_work_with_ABC() throws Exception {
        // arrange

        // act
        CurrencyUnit currencyUnit = new CurrencyUnit("1 ABC");

        // assert
        assertEquals(new BigDecimal("1"), currencyUnit.getValue());
        assertEquals(Currency.getInstance("ABC"), currencyUnit.getCurrency());
        assertEquals("1 ABC", currencyUnit.toString());
    }

}
