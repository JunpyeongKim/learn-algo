package ch01arraystring;

/**
 * 1.4 주어진 문자열 내의 모든 공백을 '%20' 으로 바꾸는 메서드를 작성하라.
 *     문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.
 *     그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.
 *     (주의 : 만일 Java 로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 한다)
 *
 *     예:
 *      입력: "Mr John Smith    ", 13
 *      출력: "Mr%20John%20Smith"
 *
 * (4E)
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 *
 * (6E)
 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'.
 *             You may assume that the string has sufficient space at the end to hold the additional characters,
 *             and that you are given the "true" length of the string.
 *             (Note: if implementing in Java, please use a character array so that you can perform this operation in place)
 *
 *             EXAMPLE:
 *              Input: "Mr John Smith    ", 13
 *              Output: "Mr%20John%20Smith"
 *
 *             Hint:
 *              #53: It's often easiest to modify strigns by going from the end of the string to the beginning.
 *              #118: You might find you need to know the number of spaces. Can you just count them?
 */
public class ArrayString04 {
    private static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ')
                return i;
        }

        return -1;
    }

    //TODO: Complexity
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        // A common approach in string manipulation is starting from the end and working backwards.
        // Using character array: because Java strings are immutable.
        // --> Using strings directly, in just one pass.
        int newLength = trueLength + spaceCount * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--newLength] = '0';
                str[--newLength] = '2';
                str[--newLength] = '%';
            } else {
                str[--newLength] = str[i];
            }
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Sample 01
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;

        replaceSpaces(arr, trueLength);

        System.out.println("\"" + str + "\"" + " -> \"" + String.valueOf(arr) + "\"");

        // Sample 02
        str = "abc d e f";
        arr = new char[str.length() + 3 * 2];

        /*
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        */
        System.arraycopy(str.toCharArray(), 0, arr, 0, str.length());

        replaceSpaces(arr, str.length());

        System.out.println("\"" + str + "\"" + " -> \"" + String.valueOf(arr) + "\"");
    }
}