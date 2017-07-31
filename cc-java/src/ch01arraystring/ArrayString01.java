package ch01arraystring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 *     다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 *
 * (4E)
 *  1.1 Implement an algorithm to determine if a string has all unique characters.
 *      What if you can not use additional data structures?
 *
 * (6E)
 *  1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
 *                 What if you can not use additional data structures?
 *                 
 *                 Hint:
 *                  #44. Try a hash table.
 *                  #117. Could a bit vector be useful?
 *                  #132. Can you solve it in O(N logN) time? What might a solution like that look like?
 */

/**
 * 문자는 캐릭터셋인 ASCII, Extended ASCII, Unicode 중의 하나에 속하므로 어느 것을 사용할 것인지 결정 필요
 *
 * 0) 가장 기본적인 체크: 문자열 길이가 캐릭터셋의 길이 이상이면 중복
 *
 * 1) boolean array 를 할당하고 ASCII 코드값이 발견되는지 체크
 * 2) HashMap/HashSet 을 이용하여 해당되는 캐릭터가 발견되지 않는지 체크
 * 3) 2개의 루프를 돌면서 동일한 캐릭터 코드가 있는지 체크
 * 4) 정렬후 --> 인접 문자가 동일한지 체크
 *
 * 5) 예외 케이스로 a~z 까지의 알파벳으로만 구성될 경우 --> 비트와이즈 연산가능 --> 메모리 최소화 가능 && 루프도 1회
 */
public class ArrayString01 {
    /*
        Check if
        - Character Set is ASCII(128: 0 ~ 127), Extended ASCII(256: 0 ~ 255), or Unicode (107,000 ???)
     */

    public static final int CHARSET_LENGTH = 128;   // 256 or 107000


    // 무식하게 boolean buffer 이용
    //--------------------------------------------------------------------------------
    // Solution #1: ASCII &
    //              Array or Hash table
    //
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

    // 메모리 사용을 줄이기 위해 HashSet 이용
    public static boolean isUniqueChars02(String str) {
        if (str.length() > CHARSET_LENGTH) {
            return false;
        }

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


    // 루프를 돌며 체크 --> 시간은 O(N^2)으로 증가하나 메모리를 줄일 수 있다.
    //--------------------------------------------------------------------------------
    // Solution #3: Without additional data structures &
    //              Extended ASCII &
    //              Compare every character with every other character
    //
    //              - Time Complexity: O((n-1)^2) --> O(n^2)
    //              - Space Complexity: O(1), no space
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


    // sorting 후 인접 문자 비교 --> sorting 에 시간/공간 소비 + 인접문자 비교에 O(N) 시간 소비
    //--------------------------------------------------------------------------------
    // Solution #4: Without additional data structures &
    //              Extended ASCII &
    //              Sort &
    //              Neighboring characters are identical
    //
    //              - Time Complexity: O(n * log n + n)  --> O(n * log n) ==> O(n)
    //              - Space Complexity: O(1)
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


    // Bitwise
    //--------------------------------------------------------------------------------
    // Solution #5: Lowercase letters('a' through 'z') &
    //              A bit vector
    //
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