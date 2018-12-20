package com.ing.training;

import com.ing.training.math.Mathematik;
import org.junit.Test;

import static com.ing.training.math.Mathematik.percentageCalculation;
import static junit.framework.TestCase.assertEquals;

public class IntrestrateTest {

    @Test
    public void if_we_invest_100_for_31_days_for_0_0_3_percent_we_get_100_25836() {
        //arrange
        double capital = 100;
        double percentage = 0.03; // 3% oder 1,25%
        int days_per_year = 365;
        int time = 31;

        //act
        double percentageCalculation = percentageCalculation(capital, percentage) * Mathematik.timeCalculation(time, days_per_year);

        //assert
        assertEquals(0.25, percentageCalculation, 0.01);
    }

}
