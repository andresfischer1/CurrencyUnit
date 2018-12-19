package com.ing.training.math;

public class Product {

    public static long factorial(int intervallEnde) {
        long laufvariable = 1;
        long sum = 1;
        while (laufvariable <= intervallEnde) {
            sum *= laufvariable;
            laufvariable++;
        }
        return sum;
    }

}