package ch10sortsearch;

import lib.AssortedMethods;

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
 *                               #298. Can you modify binary search for this purpose?
 *                               #310. What is the runtime of your algorithm? What will happen if the array has duplicates?
 */
public class SortSearch03 {
    /*
    # Strategy
      - Classic binary search --> insufficient
      --> One half of the array must be ordered normally (in increasing order)
      --> i.e, Either the left or right half must be normally ordered.
    
    # Runtime
      - O(log N) if all the elements are unique
      - O(N) with many duplicates (a.k.a linear search)
        - have to search both the left and right sides of the array
        - e.g., {2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    */

    //--------------------------------------------------------------------------------
    // Solution
    //--------------------------------------------------------------------------------    
    private static int search(int[] a, int x, int left, int right) {
        if (left > right) {
            return -1;
        }

        // Median
        int mid = (left + right) / 2;   // (left + right) >> 1
        if (a[mid] == x) {
            return mid;
        }

        // Either the left or right half must be normally ordered
        // --> Find out which side is normally ordered.
        if (a[left] < a[mid]) {
            // The left half is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, x, left, mid - 1);
            } else {
                return search(a, x, mid + 1, right);
            }
        } else if (a[left] > a[mid]) {
            // The right half is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return search(a, x, mid + 1, right);
            } else {
                return search(a, x, left, mid - 1);
            }
        } else {    // a[left] == a[mid]
            // The left half is either all repeated or loops around.
            if (a[mid] != a[right]) {
                return search(a, x, mid + 1 , right);
            } else {
                int result = search(a, x, left, mid - 1);
                if (result == -1) {
                    return search(a, x, mid + 1, right);
                }

                return result;
            }
        }
    }

    public static int search(int[] a, int x) {
        return search(a, x, 0, a.length - 1);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int[][] a = {
            {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14},
            {2, 3, 1, 2, 2, 2, 2, 2, 2, 2}
        };

        System.out.println(AssortedMethods.arrayToString(a[0]));
        System.out.println("---> search(2) = " + search(a[0], 2));  // -1
        System.out.println("---> search(3) = " + search(a[0], 3));  // 6
        System.out.println("---> search(4) = " + search(a[0], 4));  // 7
        System.out.println("---> search(1) = " + search(a[0], 1));  // 5
        System.out.println("---> search(8) = " + search(a[0], 8));  // -1

        System.out.println(AssortedMethods.arrayToString(a[1]));
        System.out.println("---> search(2) = " + search(a[1], 2));  // 4
        System.out.println("---> search(3) = " + search(a[1], 3));  // 1
        System.out.println("---> search(4) = " + search(a[1], 4));  // -1
        System.out.println("---> search(1) = " + search(a[1], 1));  // 2
        System.out.println("---> search(8) = " + search(a[1], 8));  // -1
    }
}