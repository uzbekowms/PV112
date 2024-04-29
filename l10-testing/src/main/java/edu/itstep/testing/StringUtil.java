package edu.itstep.testing;

public class StringUtil {

    public static boolean isPalindrome(String candidate) {
        return candidate.contentEquals(new StringBuilder(candidate).reverse());
    }
}
