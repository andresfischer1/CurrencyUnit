package com.ing.training.reverter;

public class Palindrom {

    public static boolean isPalindrom(StringBuilder wort) {
        if (wort.length() >= 2) {
            return checkEndOfCharactersUntilTheyAreStraight(wort);
        }
        return true;
    }

    private static boolean checkEndOfCharactersUntilTheyAreStraight(StringBuilder wort) {
        if (areFirstAndLastCharacterNotEqual(wort)) {
            return false;
        }
        return isPalindrom(wort.deleteCharAt(wort.length() - 1).deleteCharAt(0));
    }

    private static boolean areFirstAndLastCharacterNotEqual(StringBuilder wort) {
        char firstCharacter = wort.charAt(0);
        char lastCharacter = wort.charAt(wort.length() - 1);
        char firstCharacterInLowerCase = Character.toLowerCase(firstCharacter);
        char lastCharacterInLowerCase = Character.toLowerCase(lastCharacter);
        if (firstCharacterInLowerCase == lastCharacterInLowerCase) {
            return false;
        }
        return true;
    }
}
