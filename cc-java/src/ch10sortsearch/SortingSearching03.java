package ch10sortsearch;

/**
 * 10.3 n개의 정수로 구성된 정렬 상태의 배열을 임의 홧수만큼 회전시켜(rotation) 얻은 배열이 입력으로 주어진다고 하자.
 *      이 배열에서 특정한 원소를 찾는 알고리즘을 고안하라.
 *      회전시키기 이전에, 원래 배열은 오름차순으로 정렬되어 있었다고 가정한다.
 *
 *      - 예
 *          입력: {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}에서 5를 찾을 것
 *          출력: 8 (5의 배열 내의 위치 첨잣값)
 *
 * (4E)
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
 *                               Hints: #298, #310
 */

/**
 * 정렬이 된 배열이라는 것이 문제를 간단하게 만들어 준다.
 *
 * 단, 회전시켰으므로 Binary Search (O(log n)) 를 사용하면 해결이 수월해진다.
 *  <-- 반대로, O(log n) 을 구현하라고 하면, Binary Search 를 사용하면 된다.
 *
 * 검색 조건
 *  1) 범위 인덱스가 인버스 될 경우 -1
 *  2) 범위 중간값과 같으면 바로 종료
 *  3) 왼쪽, 오른쪽 중에 제대로 정렬된 곳을 찾아서 그 범위내에 찾는 값이 있으면 그 범위에서 다시 검색, 아니면 반대쪽 범위에서 검색
 *  4) 중복된 값이 연속으로 존재하는 경우도 체크 필요
 */
public class SortingSearching03 {
    private static int search(int[] a, int x, int left, int right) {
        if (left > right) {
            return -1;
        }

        // mid
        int mid = (left + right) / 2;
        if (a[mid] == x) {
            return mid;
        }

        // find the right range to compare
        if (a[left] < a[mid]) {
            if (x >= a[left] && x < a[mid]) {
                return search(a, x, left, mid - 1);
            } else {
                return search(a, x, mid + 1, right);
            }
        } else if (a[left] > a[mid]) {
            if (x > a[mid] && x <= a[right]) {
                return search(a, x, mid + 1, right);
            } else {
                return search(a, x, left, mid - 1);
            }
        } else {    // a[left] == a[mid]
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
        int[] a1 = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(search(a1, 2));
        System.out.println(search(a1, 3));
        System.out.println(search(a1, 4));
        System.out.println(search(a1, 1));
        System.out.println(search(a1, 8));

        int[] a2 = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };
        System.out.println(search(a2, 2));
        System.out.println(search(a2, 3));
        System.out.println(search(a2, 4));
        System.out.println(search(a2, 1));
        System.out.println(search(a2, 8));
    }
}