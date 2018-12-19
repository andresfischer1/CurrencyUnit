package com.ing.training.reverter;

/**
 * @author Jürgen Dufner
 * @since Release 2018-08
 */
public class ReverterRunner {

  public static void main(String[] args) {
    if (args.length > 0) {
      System.out.println(Reverter.revert(args[0]));
    }
  }

}
