package com.ing.training.reverter;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromTest {

    @Test
    public void should_be_true_because_it_is_a_palindrom() {
        // arrange

        // act
        boolean palindrom = Palindrom.isPalindrom(new StringBuilder("otto"));

        // assert
        Assert.assertTrue(palindrom);
    }

    @Test
    public void should_be_true_because_it_is_a_palindrom_even_it_is_uppercase() {
        // arrange

        // act
        boolean palindrom = Palindrom.isPalindrom(new StringBuilder("Otto"));

        // assert
        Assert.assertTrue(palindrom);


    }

    @Test
    public void should_be_true_because_it_is_a_palindrom_even_it_is_a_number() {
        // arrange

        // act
        boolean palindrom = Palindrom.isPalindrom(new StringBuilder("787"));

        // assert
        Assert.assertTrue(palindrom);
    }
}