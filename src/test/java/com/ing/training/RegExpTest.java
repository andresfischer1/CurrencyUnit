package com.ing.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

    @Test
    public void intellij_should_recognize_a_regexp_pattern() {
        // arrange
        Pattern pattern = Pattern.compile("((\\d|\\.)*\\d(,)?(\\d+)*)( )*(€|\\$|\\w{3})");

        // act
        final String input = "1.324,78 USD";
        final Matcher matcher = pattern.matcher(input);

        // assert
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("1.324,78", matcher.group(1));
        Assert.assertEquals("USD", matcher.group(6));
    }

}
