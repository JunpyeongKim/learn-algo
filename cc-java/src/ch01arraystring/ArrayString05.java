package ch01arraystring;

/**
 * 1.5 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 *     가령 압축해야 할 문자열이 aabccccccccaaa 라면 a2b1c8a3 과 같이 압축되어야 한다
 *     압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열 그대로 반환해야 한다.
 *
 * (6E)
 * 1.6 String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 *                         For example, the string aabccccccccaaa would become a2b1c8a3.
 *                         If the "compressed" string would not become smaller than the original string,
 *                         your method should return the original string.
 *                         You can assume the string has only uppercase and lowercase letters (a-z).
 *
 *                         Hints:
 *                          #92 - Do the easy thing first. Compress the string, then compare  the lengths.
 *                          #110 - Be careful that you aren't repeatedly concatenating strings together. This can be very inefficient.
 */

/**
 * 스트링을 다루므로 비효율적인 스트링 더하기가 없도록 만들어야 하는 것이 핵심이다.
 * 즉, StringBuffer, StringBuilder, Array 를 이용하여 스트링을 만들어 낸다.
 *
 * 1) 압축된 길이가 원래 길이와 달라야 한다. --> 문자열 작업을 할때는 공간 낭비가 심하므로 먼저 길이를 계산한다.
 * 2) 단순 스트링 연결 또는 버퍼(StringBuffer/StringBuilder, Array)를 이용하여 스트링을 생성
 * 3) 문자 반복을 처리하는 알고리즘을 2가지 다른 방법으로 해결 가능
 *      A) 마지막 문자 기억
 *      B) 인접 문자 비교
 */
public class ArrayString05 {
    //--------------------------------------------------------------------------------
    // Solution #1. Bad - String
    //              - Time Complexity: O(p + k^2)
    //                  - p: the size of the original string
    //                  - k: the number of character sequences
    //--------------------------------------------------------------------------------
    public static String compressBad(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String compressedString = "";

        // Alternative 01
        /*
        char last = str.charAt(0);
        int countConsecutive = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                compressedString += last + String.valueOf(countConsecutive); // or last + "" + countConsecutive;

                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        compressedString += last + String.valueOf(countConsecutive); // or last + "" + countConsecutive;
        */

        // Alternative 02
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString : str;
    }


    //--------------------------------------------------------------------------------
    // Solution #2. Better - StringBuffer/StringBuilder
    //--------------------------------------------------------------------------------
    private static int countCompression01(String str) {
        if (str == null || str.isEmpty())
            return 0;

        // Alternative 01
        /*
        int countConsecutive = 1;
        int compressedCount = 0;
        char last = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                compressedCount += 1 + String.valueOf(countConsecutive).length();
                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        compressedCount += 1 + String.valueOf(countConsecutive).length();
        */

        // Alternative 02
        int countConsecutive = 0;
        int compressedCount = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedCount += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return compressedCount;
    }

    // Counting & StringBuffer/StringBuilder
    public static String compressBetter(String str) {
        int size = countCompression01(str);
        if (size == 0 || size >= str.length())
            return str;

        StringBuffer compressedString = new StringBuffer(size);   // or StringBuilder

        // Alternative 01
        /*
        char last = str.charAt(0);
        int countConsecutive = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                compressedString.append(last);
                compressedString.append(countConsecutive);

                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        compressedString.append(last);
        compressedString.append(countConsecutive);
        */

        // Alternative 02
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString.append(str.charAt(i));
                compressedString.append(countConsecutive);

                countConsecutive = 0;
            }
        }

        return compressedString.toString();
    }


    //--------------------------------------------------------------------------------
    // Solution #3. Alternative - Counting & [CharArray(in place) | StringBuffer]
    //--------------------------------------------------------------------------------
    private static int setChar(char[] array, char c, int index, int count) {
        array[index++] = c;

//        char[] countArray = String.valueOf(count).toCharArray();
        char[] countArray = Integer.toString(count).toCharArray();

        for (char cnt : countArray) {
            array[index++] = cnt;
        }

        return index;
    }

    // Counting & CharArray(in place)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String compressAlternative(String str) {
        int size = countCompression01(str);
        if (size == 0 || size >= str.length())
            return str;

        char[] compressedString = new char[size];
        int index = 0;

        // Alternative 01
        /*
        char last = str.charAt(0);
        int countConsecutive = 1;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                index = setChar(compressedString, last, index, countConsecutive);
                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        index = setChar(compressedString, last, index, countConsecutive);
        */

        // Alternative 02
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                index = setChar(compressedString, str.charAt(i), index, countConsecutive);
                countConsecutive = 0;
            }
        }

        return new String(compressedString);    // or String.valueOf(compressedString);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] strs = {"aabccccccccaaa", "aa"};

        for (String str : strs) {
            System.out.println(str + " : \n"
                    + "\tBad - " + compressBad(str) + "\n"
                    + "\tBetter - " + compressBetter(str) + "\n"
                    + "\tAlternative - " + compressAlternative(str));
        }
    }
}