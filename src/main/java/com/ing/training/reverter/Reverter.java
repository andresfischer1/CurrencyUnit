package com.ing.training.reverter;

/**
 * @author Jürgen Dufner
 * @since Release 2018-08
 */
public class Reverter {

  public static String revert(String text) {
    if (text == null || text.equals("")) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = text.length(); i > 0 ; i--) {
      sb.append(text.charAt(i - 1));
    }
    return sb.toString();
  }

}
