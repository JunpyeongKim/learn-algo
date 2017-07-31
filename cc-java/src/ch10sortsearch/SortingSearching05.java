package ch10sortsearch;

/**
 * 10.5 빈 문자열이 섞여 있는 정렬 상태의 배열이 주어졌을 때, 특정한 문자열의 위치를 찾는 메서드를 작성하라.
 *
 *      - 예
 *          입력: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""} 배열에서 ball 을 찾아라.
 *          출력: 4
 *
 * (4E)
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

/**
 * mid 값이 Empty String 인 경우 왼쪽이든 오른쪽이든 Non-Empty String인 mid 값을 찾아서 범위를 좁혀야 한다.
 *
 * Recursive 는 stack overflow 발생 가능성과 퍼포먼스 문제가 있을수 있으므로 Iterative 로 범위를 좁혀가면서 풀 수도 있다.
 *  --> Recursive 경우, 항상 범위 에러가 발생가능하므로 범위 체크 필요
 *
 * String 같은 클래스는 Comparable 을 구현하므로 compareTo() 를 이용하여 비교 가능
 */
public class SortingSearching05 {
    // 유일한 값 --> 시간은 O(log n)
    // 중복된 값 --> 시간 O(log n) ???

    // Recursive
    private static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

        // mid value
        int mid = (first + last) / 2;

        // non-empty mid --> Non-Empty String 인 mid 값을 검색하는것이 이 문제의 포인트
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

        // compare and search
        // 그리고 String 크기/순서 비교는 Comparable.compareTo() 이용
        int result = strings[mid].compareTo(str);

        if (result == 0) {
            return mid;
        } else if (result > 0) {
            return searchR(strings, str, first, mid - 1);
        } else {
            return searchR(strings, str, mid + 1, last);
        }
    }

    // Iterative
    private static int searchI(String[] strings, String str, int first, int last) {
        while (first <= last) {
            int mid = (first + last) / 2;

            // find non-empty mid
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

            // compare and search
            int result = strings[mid].compareTo(str);
            if (result == 0) {
                return mid;
            } else if (result > 0) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return -1;
    }

    //
    public static int search(String[] strings, String str) {
        if (strings == null || str == null || strings.length == 0 || str.isEmpty()) {
            return -1;
        }

        // Recursive
        return searchR(strings, str, 0, strings.length - 1);

        // Iterative
        // return searchI(strings, str, 0, strings.length - 1);
    }

    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};

        search(stringList, "ac");
    }
}
