package com.ing.training.com.ing.training.math;

import org.junit.Test;

import java.math.BigDecimal;

import static com.ing.training.math.Percent.parsePercent;
import static org.junit.Assert.assertEquals;

public class PercentToBigDecimalTest {

    @Test
    public void when_parse_1_25_percent_expect_BigDecimal_0_0125() throws Exception {
        // arrange
        String percentAsString = "1,25%";

        // act
        BigDecimal percent = parsePercent(percentAsString); // NumberFormatter

        // assert
        assertEquals(new BigDecimal("0.0125"), percent);
    }

    @Test
    public void when_parse_1_percent_expect_BigDecimal_0_01() throws Exception {
        // arrange
        String percentAsString = "1%";

        // act
        BigDecimal percent = parsePercent(percentAsString); // NumberFormatter

        // assert
        assertEquals(new BigDecimal("0.01"), percent);
    }

    @Test
    public void when_parse_100_percent_expect_BigDecimal_1() throws Exception {
        // arrange
        String percentAsString = "100%";

        // act
        BigDecimal percent = parsePercent(percentAsString); // NumberFormatter

        // assert
        assertEquals(new BigDecimal("1"), percent);
    }

}
