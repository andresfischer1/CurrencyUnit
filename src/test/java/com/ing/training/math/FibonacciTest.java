package com.ing.training.math;

import org.junit.Test;

import static com.ing.training.math.Mathematik.fibonacci;
import static org.junit.Assert.assertEquals;

/**
 * Test of Fibonacci numbers.
 * fib(i) = fib(i-1) + fib(i-2)
 *
 * fib(1) = 1
 *
 * fib(2) = 1
 *
 * fib(3) = fib(2) + fib(1)
 *        = 1 + 1
 *        = 2
 *
 * fib(4) = fib(3) + fib(2)
 *        = 2 + 1
 *        = 3
 *
 * 1, 1, 2, 3, 5, 8, 13, 21, 44, ...
 */
public class FibonacciTest {

    @Test
    public void fibonacci_of_1_is_1() {
        // arrange

        // act
        long fib = fibonacci(1);

        // assert
        assertEquals(1, fib);
    }

    @Test
    public void fibonacci_of_2_is_1() {
        // arrange

        // act
        long fib = fibonacci(2);

        // assert
        assertEquals(1, fib);
    }

    @Test
    public void fibonacci_of_3_is_2() {
        // arrange

        // act
        long fib = fibonacci(3);

        // assert
        assertEquals(2, fib);
    }

    @Test
    public void fibonacci_of_4_is_3() {
        // arrange

        // act
        long fib = fibonacci(4);

        // assert
        assertEquals(3, fib);
    }

    @Test
    public void fibonacci_of_13_is_233() {
        // arrange

        // act
        long fib = fibonacci(13);

        // assert
        assertEquals(233, fib);
    }

}
