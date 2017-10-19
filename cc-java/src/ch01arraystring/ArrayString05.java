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
public class ArrayString05 {
    //--------------------------------------------------------------------------------
    // Solution #1. Bad: String + charAt()
    //              - Time Complexity: O(p + k^2) <-- k^2 은 문자열을 합하는 연산 시간
    //                  - p: the size of the original string
    //                  - k: the number of character sequences
    //                  - e.g., aabccdeeaa --> k == 6
    //--------------------------------------------------------------------------------
    public static String compressBad(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String compressedString = "";

        // Alternative 01
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

    public static String compressBadAlternative(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String compressedString = "";

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

        return compressedString.length() < str.length() ? compressedString : str;
    }


    //--------------------------------------------------------------------------------
    // Solution #2. Better: StringBuilder + charAt()
    //              - 문자열 합하는 시간(k^2)을 줄이기 위해 StringBuilder/StringBuffer 사용
    //--------------------------------------------------------------------------------
    public static String compressBetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressedString.append(str.charAt(i));
                compressedString.append(countConsecutive);

                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    public static String compressBetterAlternative(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressedString = new StringBuilder();
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

        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    //--------------------------------------------------------------------------------
    // Solution #3. Best: StringBuffer + charAt() + count
    //              - 문자열 합하는 시간(k^2)을 줄이기 위해 StringBuilder/StringBuffer 사용
    //TODO: Complexity
    //--------------------------------------------------------------------------------
    private static int countCompression(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int countConsecutive = 0;
        int countCompressed = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                countCompressed += 1 + String.valueOf(countConsecutive).length();   // e.g., a2 --> 2
                countConsecutive = 0;
            }
        }

        return countCompressed;
    }

    public static String compressBest(String str) {
        int size = countCompression(str);
        if (size == 0 || size >= str.length())
            return str;

        StringBuffer compressed = new StringBuffer(); // thread-safe
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    //--------------------------------------------------------------------------------
    // Solution #4. Best & Alternative: Array + charAt() + count
    //              --> 변환 결과 문자열의 길이 계산 --> 배열 이용
    //TODO: Complexity
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(n)
    //--------------------------------------------------------------------------------
    private static int setChar(char[] array, int index, char c, int count) {
        array[index++] = c;

       char[] countArray = String.valueOf(count).toCharArray();  // or Integer.toString(count).toCharArray();

        for (char cnt : countArray) {
            array[index++] = cnt;
        }

        return index;
    }

    private static int countCompressionAlternative01(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int countCompressed = 0;
        int countConsecutive = 0;

        for (int i = 1; i < str.length(); i++) {
            countConsecutive++;

            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                countCompressed += 1 + String.valueOf(countConsecutive).length();   // e.g., a2 --> 2
                countConsecutive = 0;
            }
        }

        return countCompressed;
    }

    public static String compressBestAlternative01(String str) {
        int size = countCompressionAlternative01(str);
        if (size == 0 || size >= str.length())
            return str;

        char[] compressed = new char[size];
        int countConsecutive = 0;
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                index = setChar(compressed, index, str.charAt(i), countConsecutive);
                countConsecutive = 0;
            }
        }

        return String.valueOf(compressed);  // or new String(compressed);
    }

    private static int countCompressionAlternative02(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int countCompressed = 0;
        int countConsecutive = 1;
        char last = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                countCompressed += 1 + String.valueOf(countConsecutive).length();   // e.g., a2 --> 2
                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        countCompressed += 1 + String.valueOf(countConsecutive).length();   // e.g., a2 --> 2

        return countCompressed;
    }

    public static String compressBestAlternative02(String str) {
        int size = countCompressionAlternative02(str);
        if (size == 0 || size >= str.length())
            return str;

        char[] compressed = new char[size];
        char last = str.charAt(0);
        int countConsecutive = 1;
        int index = 0;

        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                countConsecutive++;
            } else {
                index = setChar(compressed, index, last, countConsecutive);
                last = str.charAt(i);
                countConsecutive = 1;
            }
        }

        index = setChar(compressed, index, last, countConsecutive);

        return String.valueOf(compressed);  // or new String(compressed);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] strs = {"aabccccccccaaa", "aa"};

        for (String str : strs) {
            System.out.println(str + " : \n"
                    + "---> Bad(String + charAt()): " + compressBad(str) + ", " + compressBadAlternative(str) + "\n"
                    + "---> Better(StringBuilder + charAt()): " + compressBetter(str) + ", " + compressBetterAlternative(str) + "\n"
                    + "---> Best(StringBuffer + charAt() + count): " + compressBest(str) + "\n"
                    + "---> BestAlternative(Array + charAt() + count): " + compressBestAlternative01(str) + ", " + compressBestAlternative02(str));
        }
    }
}