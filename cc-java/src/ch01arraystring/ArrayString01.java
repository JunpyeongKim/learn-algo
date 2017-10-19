package ch01arraystring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 *     다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 *
 * (4E)
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 *      What if you can not use additional data structures?
 *
 * (6E)
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
 *                 What if you can not use additional data structures?
 *
 *                 Hint:
 *                  #44. Try a hash table.
 *                  #117. Could a bit vector be useful?
 *                  #132. Can you solve it in O(N logN) time? What might a solution like that look like?
 */
public class ArrayString01 {
    public static final int CHARSET_LENGTH = 128;   // Character Set is ASCII(128: 0 ~ 127), Extended ASCII(256: 0 ~ 255), or Unicode (107,000 ???)


    //--------------------------------------------------------------------------------
    // Solution #1: Boolean Array
    //TODO: Complexity
    //              - n (the length of the string)
    //                  - Time Complexity: O(n)
    //                  - Space Complexity: O(1)
    //              - c (the size of the character set)
    //                  - Time Complexity: O(c) or O(min(c, n))
    //                  - Space Complexity: O(c)
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars01(String str) {
        if (str.length() > CHARSET_LENGTH)
            return false;

        boolean[] charSet = new boolean[CHARSET_LENGTH];

        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i);

            if (charSet[code])
                return false;

            charSet[code] = true;
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #2: HashMap/HashSet <-- to reduce amount of memory
    //TODO: Complexity
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars02(String str) {
        if (str.length() > CHARSET_LENGTH)
            return false;

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i);

            if (!set.contains(code)) {
                set.add(code);
            } else {
                return false;
            }
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #3: Compare every character --> Two Loops
    //              - Time Complexity: O((n-1)^2) --> O(n^2)
    //              - Space Complexity: O(1), no space <-- No additional data structures
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars03(String str) {
        if (str.length() > CHARSET_LENGTH)
            return false;

        int len = str.length();

        for (int i = 0; i < len - 1; i++) {
            char code = str.charAt(i);

            for (int j = i + 1; j < len; j++) {
                if (code == str.charAt(j))
                    return false;
            }
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #4: Sorting && Neighboring characters are identical --> One Loop
    //              - Time Complexity: O(nlog(n) + n)  --> O(nlog(n)) ==> O(n)
    //              - Space Complexity: O(1) <-- No additional data structures
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars04(String str) {
        if (str.length() > CHARSET_LENGTH)
            return false;

        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);  // in O(n * log n) time, Though many sorting algorithms take up extra space.

        for (int i = 0; i < strArray.length - 1; i++) {
            if (strArray[i] == strArray[i+1])
                return false;
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Solution #5: A bit vector --> Lowercase letters('a' through 'z')
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static boolean isUniqueChars05(String str) {
        if (str.length() > 26)
            return false;

        // a bit vector,
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int shift = str.charAt(i) - 'a';    // normalize
            int bitVector = 1 << shift;

            if ((checker & bitVector) > 0)
                return false;

            checker |= bitVector;
        }

        return true;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for (String word : words) {
            System.out.println(word + " : "
                    + isUniqueChars01(word) + ", "
                    + isUniqueChars02(word) + ", "
                    + isUniqueChars03(word) + ", "
                    + isUniqueChars04(word) + ", "
                    + isUniqueChars05(word));
        }
    }
}