package ch10sortsearch;

import lib.AssortedMethods;

/**
 * 10.1 정렬된 배열 A와 B가 주어진다. A의 끝에는 B를 수용하기 충분한 여유 공간이 있다.
 *      B와 A를 정렬된 상태로 병합하는 메서드를 작성하라.
 *
 * (4E)
 * 11.1 You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 *      Write a method to merge B into A in sorted order.
 *
 * (6E)
 * 10.1 Sorted Merge: You are given two sorted arrays, A and B,
 *                    where A has a large enough buffer at the end to hold B.
 *                    Write a method to merge B into A in sorted order.
 *
 *                    Hint #332. Try moving from the end of the array to the beginning.
 *
 */

/**
 * merge sort 의 일부를 문제로 낸 것인데,
 * B를 A에 머지하는것이므로 B를 기준으로 루프를 돌린다.
 * 정렬된 배열의 병합은 가장 뒤에서부터 병합하는것이 정렬을 유지하기 좋은 전략이다.
 * B를 기준으로 병합이 끝나면 루프는 종료하면 된다. 왜냐면 혹시나 남아있는 A도 이미 정렬된 상태이니까
 *
 * 단, 배열이 Ascending Sorting 으로 가정하고 풀었는데...문제 어디에도 ASC, DESC 는 언급이 없다. 주의 필요
 */
public class SortingSearching01 {
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

        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }
}