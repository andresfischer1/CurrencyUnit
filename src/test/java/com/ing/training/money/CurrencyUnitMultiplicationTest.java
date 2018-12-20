package com.ing.training.money;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CurrencyUnitMultiplicationTest {

    @Test
    public void currencyUnitMultiplicationTest_should_have_a_multiply_method() throws Exception {
        // arrange
        CurrencyUnit hundred_euros = new CurrencyUnit("100€");
        Percent ten_percent = new Percent("10%");

        // act
        CurrencyUnit ten_euros = hundred_euros.multiply(ten_percent);

        // assert
        assertEquals(new CurrencyUnit("10€"), ten_euros);
    }

    @Test
    public void currencyUnitMultiplicationTest_should_have_a_multiply_method_thats_rounds() throws Exception {
        // arrange
        CurrencyUnit mass = new CurrencyUnit("100,47€");
        Percent percent = new Percent("12,37%");

        // act
        CurrencyUnit result = mass.multiply(percent);

        // assert
        assertEquals(new CurrencyUnit("12,43€"), result);
    }

    @Test
    public void currencyUnitMultiplicationTest_should_work_with_other_currencies() throws Exception {
        // arrange
        CurrencyUnit mass = new CurrencyUnit("100,47 $");
        Percent percent = new Percent("12,37%");

        // act
        CurrencyUnit result = mass.multiply(percent);

        // assert
        assertEquals(new CurrencyUnit("12,43 $"), result);
    }

}