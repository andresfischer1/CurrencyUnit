package com.ing.training.money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import java.math.BigDecimal;
import org.junit.Test;

public class PercentTest {

    @Test
    public void percent_class_should_exist() throws Exception {
        // arrange

        // act
        Percent percent = new Percent("1,25%");

        // assert
        assertEquals(new BigDecimal("0.01250"), percent.getAsBigDecimal());
    }

    @Test
    public void percent_class_should_be_normalized() throws Exception {
        //arrange

        //act
        Percent percent = new Percent("1%");

        //arrange
        assertEquals(new BigDecimal("0.01000"), percent.getAsBigDecimal());
    }

    @Test
    public void percent_class_from_string_should_be_normalized_and_rounded() throws Exception {
        //arrange

        //act
        Percent percent = new Percent("1,3789123%");

        //arrange
        assertEquals(new BigDecimal("0.01379"), percent.getAsBigDecimal());
    }

    @Test
    public void percent_class_from_string_should_set_internal_big_decimal() throws Exception {
        //arrange

        //act
        Percent percent = new Percent("1,3789123%");

        //arrange
        assertEquals(new BigDecimal("0.01379"), percent.getAsBigDecimal());
    }

    @Test
    public void percent_class_from_bigdecimal_should_be_normalized() throws Exception {
        //arrange

        //act
        Percent percent = new Percent(new BigDecimal("2"));

        //arrange
        assertEquals(new BigDecimal("2.00000"), percent.getAsBigDecimal());
        assertEquals("200,00%", percent.toString());
    }

    @Test
    public void percent_class_from_bigdecimal_should_be_rounded() throws Exception {
        //arrange

        //act
        Percent percent = new Percent(new BigDecimal("0.024567"));

        //arrange
        assertEquals(new BigDecimal("0.02457"), percent.getAsBigDecimal());
    }

    @Test
    public void percent_class_should_have_a_toString_method() throws Exception {
        //arrange

        //act
        Percent percent = new Percent("2%");

        //arrange
        assertEquals("2,00%", percent.toString());
    }

    @Test
    public void percent_class_should_have_a_toString_method_with_decimal_separator() throws Exception {
        //arrange

        //act
        Percent percent = new Percent("150%");

        //arrange
        assertEquals("150,00%", percent.toString());
    }

    @Test
    public void percent_class_should_implement_equals_and_hashcode() throws Exception {
        // arrange
        Percent onePercent = new Percent("1%");
        Percent anotherOnePercent = new Percent ("1,00%");

        // act + assert
        assertEquals(onePercent, anotherOnePercent);

    }

    @Test
    public void when_parse_1_25_percent_without_space_expect_BigDecimal_1_25() throws Exception {
        // arrange
        String percentAsString = "1,25%";

        // act
        BigDecimal percent = Percent.parsePercent(percentAsString); // NumberFormatter

        // assert
        assertEquals(new BigDecimal("0.0125"), percent);
    }

    @Test
    public void one_percent_is_not_equals_two_percent() throws Exception {
        // arrange
        Percent percent1 = new Percent("1%");
        Percent percent2 = new Percent("2%");

        // act

        // assert
        assertNotEquals(percent1, percent2);
        assertNotEquals(percent1.hashCode(), percent2.hashCode());
    }

    @Test
    public void one_percent_is_equals_one_percent_but_not_same() throws Exception {
        // arrange
        String percentAsString = "1%";

        // act
        Percent percent1 = new Percent(percentAsString);
        Percent percent2 = new Percent(percentAsString);

        // assert
        assertEquals(percent1, percent2);
        assertEquals(percent1.hashCode(), percent2.hashCode());
        assertNotSame(percent1, percent2);
    }

}