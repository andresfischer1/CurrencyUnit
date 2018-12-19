package com.ing.training.math;

import org.junit.Test;

import static com.ing.training.math.Product.factorial;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void product_from_1_to_1_should_be_1(){
        //arrange

        //act
        long product = factorial(1);

        //assert
        assertEquals(1,product);
    }

    @Test
    public void product_from_1_to_2_should_be_2(){
        //arrange

        //act
        long product = factorial(2);

        //assert
        assertEquals(2,product);
    }

    @Test
    public void product_from_1_to_3_should_be_6(){
        //arrange

        //act
        long product = factorial(3);

        //assert
        assertEquals(6,product);
    }

    @Test
    public void product_from_1_to_10_should_be_3628800(){
        //arrange

        //act
        long product = factorial(10);

        //assert
        assertEquals(3_628_800,product);
    }
}