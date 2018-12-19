package com.ing.training.reverter;

import static com.ing.training.reverter.Reverter.revert;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jürgen Dufner
 * @since Release 2018-08
 */
public class ReverterTest {

  @Test
  public void function_revert_should_revert_the_text_abc() {
    // arrange
    String input = "abc";

    // act
    String reverseString = revert(input);

    // assert
    Assert.assertEquals("cba", reverseString);
  }

  @Test
  public void function_revert_should_revert_the_text_def() {
    // arrange
    String input = "def";

    // act
    String reverseString = revert(input);

    // assert
    Assert.assertEquals("fed", reverseString);
  }

  @Test
  public void function_revert_should_return_empty_string_when_null() {
    // arrange
    String input = null;

    // act
    String reverseString = revert(input);

    // assert
    Assert.assertEquals("", reverseString);
  }

}
