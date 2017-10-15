package ch01arraystring;

import java.util.Arrays;

/**
 * 1.3 문자열 두 개를 입력으로 받아 그 중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
 *
 * (4E)
 * 1.4 Write a method to decide if two strings are anagrams or not.
 *
 * (6E)
 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 *                        Hints: #1, #84, #122, #131
 */

/**
 * Permutation 은
 *  1) 길이가 동일해야 한다
 *  2) 문자의 출현 빈도수가 동일해야한다 --> 즉, 정렬하면 동일해야한다
 */
public class ArrayString03 {
    /*
        Permutation --> Two strings have the same characters, but in different order.

        Assume that
            - 1) the comparison is case-sensitive
            - 2) whitespace is significant.
     */


    //--------------------------------------------------------------------------------
    // Solution #1: Sort the strings
    //              - not as optimal, but clean, simple, and easy to understand.
    //              - In a practical sense, may very well be a superior way.
    //--------------------------------------------------------------------------------
    public static String sort(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);    // or String.valueOf(strArray);
    }

    public static boolean permutation01(String s, String t) {
        // Permutations must be the same length
        if (s == null || t == null || s.length() != t.length())
            return false;

        // Sort and compare
        return sort(s).equals(sort(t));
    }


    //--------------------------------------------------------------------------------
    // Solution #2: Check if the two strings have identical counts for each unique char.
    //--------------------------------------------------------------------------------
    public static boolean permutation02(String s, String t) {
        // Permutations must be the same length
        if (s == null || t == null || s.length() != t.length())
            return false;

        // Occurrences: ASCII(128), Extended-ASCII(256), Unicode(117,000~)
        int[] charSet = new int[256]; // Extended ASCII
        int numOfUniqueChar = 0;
        int numOfCompletedChar = 0;

        // Counting how many times each character appears.
        for (int i = 0; i < s.length(); i++) {
            char code = s.charAt(i);

            // Complementary; Optional
            if (charSet[code] == 0)
                numOfUniqueChar++;

            // Increase
            charSet[code]++;
        }

        // Compare
        for (int j = 0; j < t.length(); j++) {
            char code = t.charAt(j);

            // Decrease
            if (--charSet[code] < 0)
                return false;

            // Complementary; Optional
            if (charSet[code] == 0)
                numOfCompletedChar++;
        }

        // Complementary; Optional
        if (numOfUniqueChar != numOfCompletedChar)
            return false;

        return true;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];

            System.out.println(word1 + " - " + word2 + " : "
                    + permutation01(word1, word2) + ", "
                    + permutation02(word1, word2));
        }
    }
}