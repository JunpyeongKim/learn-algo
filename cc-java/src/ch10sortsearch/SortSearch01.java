package ch10sortsearch;

import lib.AssortedMethods;

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
 *                    #332. Try moving from the end of the array to the beginning.
 */
public class SortSearch01 {
    /*
    # Strategy
      - a part of the standard merge-sort
      - merge A and B from the back by comparing each element.
      --> Since A has enough buffer at the end, it's better to insert elements into the back of the array.
    
    # Check if Ascending or Descending order
      --> Assume ascending order
    */

    //--------------------------------------------------------------------------------
    // Solution
    //--------------------------------------------------------------------------------
    public static void merge(int[] a, int[] b, int lenA, int lenB) {
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        int indexMerged = lenA + lenB - 1;

        // Note that you don't need to copy the contents of A after running out of elements in B.
        // They are already in place.
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }

            indexMerged--;
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};

        System.out.println("  " + AssortedMethods.arrayToString(a));
        System.out.println("+ " + AssortedMethods.arrayToString(b));

        merge(a, b, 8, 6);
        
        System.out.println("  " + AssortedMethods.arrayToString(a));
    }
}