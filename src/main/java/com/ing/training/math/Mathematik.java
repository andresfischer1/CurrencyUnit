package com.ing.training.math;

public class Mathematik {

    public static long sumOfAllNumbers(int intervallEnde) {
        return ((long)intervallEnde * (intervallEnde + 1))/2;
        //return sumOfAllNumberSlowly(intervallEnde);
    }

    private static long sumOfAllNumberSlowly(int intervallEnde) {
        long laufvariable = 1;
        long sum = 0;
        while (laufvariable <= intervallEnde) {
            sum += laufvariable;
            laufvariable++;
        }
        return sum;
    }

    public static long fibonacci(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 1;
        }
        return fibonacci(i -1) + fibonacci(i - 2);
    }

    public static double percentageCalculation(double mass, double percentage) {
        return mass * percentage;
    }

    public static double timeCalculation(int time, int days_per_year) {
        return (double) time / days_per_year;
    }

}
