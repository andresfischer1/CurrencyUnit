package com.ing.training.math;

import org.junit.Test;

import static com.ing.training.math.Mathematik.sumOfAllNumbers;
import static org.junit.Assert.assertEquals;

public class MathematikTest {

    @Test
    public void sum_of_one_should_be_one() {
        // arrange
        
        // act
        long sum = sumOfAllNumbers(1);
        
        // assert
        assertEquals(1, sum);
    }
    
    @Test
    public void sum_of_all_numbers_between_one_and_two_should_be_three() {
        // arrange

        // act
        long sum = sumOfAllNumbers(2);

        // assert
        assertEquals(3, sum);
    }

    @Test
    public void sum_of_all_numbers_between_one_and_three_should_be_six() {
        // arrange

        // act
        long sum = sumOfAllNumbers(3);

        // assert
        assertEquals(6, sum);
    }

    @Test
    public void sum_of_all_numbers_between_one_and_ten_should_be_fiftyfive() {
        // arrange

        // act
        long sum = sumOfAllNumbers(10);

        // assert
        assertEquals(55, sum);
    }

    @Test
    public void sum_of_all_numbers_between_one_and_hundred_should_be_5050() {
        // arrange

        // act
        long sum = sumOfAllNumbers(100);

        // assert
        assertEquals(5050, sum);
    }

    @Test(timeout=5)
    public void sum_from_1_to_1_000_000_000_should_be_500_000_000_500_000_000() {
        // arrange

        // act
        long summe = sumOfAllNumbers(1_000_000_000);

        // assert
        assertEquals(500_000_000_500_000_000L, summe);
    }

}
