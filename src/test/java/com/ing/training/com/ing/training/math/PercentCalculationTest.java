package com.ing.training.com.ing.training.math;

import org.junit.Test;

import static com.ing.training.math.Mathematik.percentageCalculation;
import static junit.framework.TestCase.assertEquals;

/**
 * (mass * percentage) - mass = new mass
 *  (20 * 0,03) - 20 = 19,40
 */
public class PercentCalculationTest {

    @Test
    public void when_2_percent_of_125_should_be_0_25() {
        //arrange
        double mass4711 = 125;
        double percentage0815 = 0.02;

        //act
        double percentageQuotation = percentageCalculation(mass4711, percentage0815);

        //assert
        assertEquals(2.5, percentageQuotation);
    }

    @Test
    public void when_0_2_percent_of_1_000_000_should_be_2_000() {
        //arrange
        double mass4711 = 1_000_000;
        double percentage0815 = 0.002;

        //act
        double percentageQuotation = percentageCalculation(mass4711, percentage0815);

        //assert
        assertEquals(2000d, percentageQuotation);
    }

    @Test
    public void when_0_2_percent_of_1_should_be_0_002() {
        //arrange
        double mass4711 = 1;
        double percentage0815 = 0.002;

        //act
        double percentageQuotation = percentageCalculation(mass4711, percentage0815);

        //assert
        assertEquals(0.002, percentageQuotation);
    }

    @Test
    public void when_reduce_of_0_0_3_percent_of_20_should_be_19_40() {
        //arrange
        double mass4711 = 20;
        double percentage0815 = 0.03;

        //act
        double percentageCalculation = percentageCalculation(mass4711, percentage0815);

        //assert
        assertEquals(0.6, percentageCalculation);
    }

}
