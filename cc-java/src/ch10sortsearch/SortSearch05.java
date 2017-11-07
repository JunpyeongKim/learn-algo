package ch10sortsearch;

import lib.AssortedMethods;

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
public class SortSearch05 {
    /* 
    # Strategy
        - Simply use binary search.
        --> a simple modification of binary search : fix the comparision against mid.
        --> We simply move mid into the closest non-empty string

    # Runtime
        - In the worst case, i.e. {"", "", "", ..., "last"} --> O(N)
        - 모든 원소가 Unique --> O(logN)
        - 원소가 Duplicate --> O(N)

    # The recursive code can easily be modified to be iterative.
    */


    //--------------------------------------------------------------------------------
    // Solution #1: Recursion
    //              --> Excessive Call Stack 사용 --> StackOverflowException 발생 및 Performance 저하 가능성
    //              --> 되도록 Iteration 을 이용하자.
    //--------------------------------------------------------------------------------
    private static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

        // Median
        int mid = (first + last) / 2;   // (first + last) >> 1;

        // (Important!!!) Find the closest non-empty median
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        // Compare and search
        int result = strings[mid].compareTo(str);   // Comparable.compareTo()

        if (result == 0) {
            return mid;
        } else if (result > 0) {    // left
            return searchR(strings, str, first, mid - 1);
        } else {    // right
            return searchR(strings, str, mid + 1, last);
        }
    }

    //--------------------------------------------------------------------------------
    // Solution #2: Iteration
    //--------------------------------------------------------------------------------
    private static int searchI(String[] strings, String str, int first, int last) {
        while (first <= last) {
            // Median
            int mid = (first + last) / 2;   // (first + last) >> 1

            // (Important!!!) Find the closest non-empty median
            if (strings[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;

                while (true) {
                    if (left < first && right > last) {
                        return -1;
                    } else if (left >= first && !strings[left].isEmpty()) {
                        mid = left;
                        break;
                    } else if (right <= last && !strings[right].isEmpty()) {
                        mid = right;
                        break;
                    }

                    left--;
                    right++;
                }
            }

            // Compare and search
            int result = strings[mid].compareTo(str);   // Comparable.comareTo()
            if (result == 0) {
                return mid;
            } else if (result > 0) {    // left
                last = mid - 1;
            } else {    // right
                first = mid + 1;
            }
        }

        return -1;
    }

    //
    public static int search(String[] strings, String str) {
        if (strings == null || strings.length == 0 || str == null || str.isEmpty()) {
            return -1;
        }

        // Recursion
        int indexRecursion = searchR(strings, str, 0, strings.length - 1);

        // Iteration
        int indexIteration = searchI(strings, str, 0, strings.length - 1);

        if (indexRecursion == indexIteration) {
            return indexRecursion;
        }

        System.out.println("indexRecursion != indexIteration --> " + indexRecursion + " != " + indexIteration);
        return -1;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(AssortedMethods.stringArrayToString(stringList));

        System.out.println("<ac> is appears at location " + search(stringList, "ac"));

        for (String s : stringList) {
            if (!s.isEmpty()) {
                System.out.println("<" + s + "> is appears at location " + search(stringList, s));
            }
        }
    }
}