package ch10sortsearch;

// Done 1
/**
 * 10.1 정렬된 배열 A와 B가 주어진다.
 *      A의 끝에는 B를 수용하기 충분한 여유 공간이 있다.
 *      B와 A를 정렬된 상태로 병합하는 메서드를 작성하라.
 *
 * (4E) ---> (5E) 11.1
 * 9.1 You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. 
 *     Write a method to merge B into A in sorted order.
 *
 * (6E)
 * 10.1 Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. 
 *                    Write a method to merge B into A in sorted order.
 *
 *                    Hints: 
 *                    #332
 */

// Done 2
/**
 * 10.2 철자 순서만 바꾼 문자열이 서로 인접하도록 문자열 배열을 정렬하는 메서드를 작성하라.
 *
 * (4E) ---> (5E) 11.2
 * 9.2 Write a method to sort an array of strings so that all the anagrams are next to each other.
 *
 * (6E)
 * 10.2 Group Anagrams: Write a method to sort an array of strings so that all anagrams are next to each other.
 * 
 *                      Hints: 
 *                      #177 
 *                      #182 
 *                      #263 
 *                      #342
 */

// Done 3
/**
 * 10.3 n개의 정수로 구성된 정렬 상태의 배열을 임의 홧수만큼 회전시켜(rotation) 얻은 배열이 입력으로 주어진다고 하자.
 *      이 배열에서 특정한 원소를 찾는 알고리즘을 고안하라.
 *      회전시키기 이전에, 원래 배열은 오름차순으로 정렬되어 있었다고 가정한다.
 *
 *      - 예
 *          입력: {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}에서 5를 찾을 것
 *          출력: 8 (5의 배열 내의 위치 첨잣값)
 *
 * (4E) ---> (5E) 11.3
 * 9.3 Given a sorted array of n integers that has been rotated an unknown number of times, 
 *     give an O(log n) algorithm that finds an element in the array. 
 *     You may assume that the array was originally sorted in increasing order.
 *
 *     EXAMPLE:
 *      Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *      Output: 8 (the index of 5 in the array)
 *
 * (6E)
 * 10.3 Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times, 
 *                               write code to find an element in the array. 
 *                               You may assume that the array was originally sorted in increasing order.
 *
 *                               EXAMPLE
 *                                  Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 *                                  Output: 8 (the index of 5 in the array)
 *
 *                               Hints: 
 *                               #298
 *                               #310
 */


// WIP 4
/**
 * 10.4 줄당 하나의 문자열이 들어 있는 20GB짜리 파일이 있다고 하자.
 *      이 파일을 정렬하려면 어떻게 해야 하겠는지 설명하라.
 * 
 * (4E) ---> (5E) None
 * 9.4 If you have a 2 GB file with one string per line, 
 *     which sorting algorithm would you use to sort the file and why?
 * 
 * (6E)
 * 10.6 Sort Big File: Imagine you have a 20 GB file with one string per line. 
 *                     Explain how you would sort the file.
 *                     
 *                     Hints: 
 *                     #207
 */


// Done 5
/**
 * 10.5 빈 문자열이 섞여 있는 정렬 상태의 배열이 주어졌을 때, 특정한 문자열의 위치를 찾는 메서드를 작성하라.
 *
 *      - 예
 *          입력: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""} 배열에서 ball 을 찾아라.
 *          출력: 4
 *
 * (4E) ---> (5E) 11.5
 * 9.5 Given a sorted array of strings which is interspersed with empty strings, 
 *     write a method to find the location of a given string.
 *
 *     Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] will return 4
 *     Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] will return -1
 *
 * (6E)
 * 10.5 Sparse Search: Given a sorted array of strings that is interspersed with empty strings, 
 *                     write a method to find the location of a given string.
 *
 *                     EXAMPLE
 *                      Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 *                      Output: 4
 *
 *                     Hints: #256
 */

# 10.5 
    빈 문자열이 섞여 있는 정렬 상태의 배열이 주어졌을 때, 특정한 문자열의 위치를 찾는 메서드를 작성하라.

    - 예
      입력: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""} 배열에서 ball 을 찾아라.
      출력: 4

(4E) ---> (5E) 11.5

> 9.5 Given a sorted array of strings which is interspersed with empty strings,
> write a method to find the location of a given string.
> Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] will return 4
> Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] will return -1

- (6E)
    10.5 Sparse Search: Given a sorted array of strings that is interspersed with empty strings,


// TBD 6
/**
 * 10.6
 */


// TBD 7
/**
 * 10.7
 */


// TBD 8
/**
 * 10.8
 */

 

//--------------------------------------------------------------------------------
// Completed 
// --> KE(8개: 1, 2, 3, 5, - 4, 6, 7, 8)
// --> 4E(7개: 1, 2, 3, 5, - 4, 6, 7)
// --> 6E(11개: 1, 2, 3,5, - 4, 6, 7, 8, 9, 11)
//--------------------------------------------------------------------------------


//--------------------------------------------------------------------------------
// 연관된 다른 문제
// 배열과 문자열(1.3), 재귀(9.3), 중간 난이도 연습 문제(17.6, 17.12), 고난이도 연습문제(18.5)
//
// 6E
// Additional Questions: Arrays and Strings (#1.2), Recursion (#8.3), Moderate (#16.10, #16.16, #16.21, #16.24),
// Hard (#17.11 , #17.26).
//--------------------------------------------------------------------------------
public class SortingSearching {}