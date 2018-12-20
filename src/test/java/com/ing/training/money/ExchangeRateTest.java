package com.ing.training.money;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class ExchangeRateTest {

  @Test
  public void class_has_immutable_constructor() throws Exception {
    // arrange
    ExchangeRate exchangeRate = new ExchangeRate("1,9558");

    // act
    BigDecimal value = exchangeRate.getValue();

    // assert
    Assert.assertEquals(new BigDecimal("1.9558"), value);
  }

}