package ch01arraystring;

// 1st 정리 기준 : Korean Edition 기준으로 정리

// Done 1
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

// TBD 2
/**
 * 1.2 널 문자로 끝나는 문자열을 뒤집는 reverse(char* str) 함수를 C나 C++로 구현하라.
 *
 * (4E)
 * 1.2 Write code to reverse a C-Style String.
 *     (C-String means that “abcd” is represented as five characters, including the null character.)
 */

// Done 3
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


// Done 4
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

// Done 5
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

// TBD 6
/**
 * 1.6 이미지를 표현하는 NxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
 *     이때, 이미지를 90도 회전시키는 메서드를 작성하라.
 *     부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?
 *
 * (6E)
 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 *                    write a method to rotate the image by 90 degrees.
 *                    Can you do this in place?
 *
 *                    Hints: #51, #100
 */

// Done 7
/**
 * 1.7 MxN 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
 *
 * (4E)
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0,
 *     its entire row and column is set to 0.
 *
 * (6E)
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 *                  its entire row and column are set to 0.
 *
 *                  Hints: #17, #74, #102
 */

// Done 8
/**
 * 1.8 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubString 이라는 메서드가 있다고 하자.
 *     s1과 s2의 두 문자열이 주어졌을 때, s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubString 을 한번만 호출하도록 하여 작성하라.
 *     (가령 'waterbottle'은 'erbottlewat'을 회전하여 얻을 수 있는 문자열이다.)
 *
 * (4E)
 * 1.8 Assume you have a method isSubstring which checks if one word is a substring of another.
 *     Given two strings, s1 and s2,
 *     write code to check if s2 is a rotation of s1 using only one call to isSubstring
 *     (i.e., “waterbottle” is a rotation of “erbottlewat”).
 *
 * (6E)
 * 1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
 *                      Given two strings, s1 and s2,
 *                      write code to check if s2 is a rotation of s1 using only one call to isSubstring
 *                      (e.g., “waterbottle” is a rotation of “erbottlewat”).
 *
 *                      Hints: #34, #88, #104
 */

//--------------------------------------------------------------------------------
// English Edition: KE(8개: 3, 4, 5, 7, 8), 4E(8개: 4, 5, 7, 8), 6E(9개: 2, 3, 6, 8, 9)
//--------------------------------------------------------------------------------
public class ArrayString {
}

//--------------------------------------------------------------------------------
// Related Problems: #8
//--------------------------------------------------------------------------------
/**
 *
 * 비트 조작(5.7), 객체지향설계(7.10), 재귀(9.3), 정렬과 탐색(9.6), C++(13.10), 중간 난이도 연습문제(17.7, 17.8, 17.14)
 */
