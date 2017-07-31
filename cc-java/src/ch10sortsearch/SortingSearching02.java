package ch10sortsearch;

import lib.AssortedMethods;
import lib.HashMapList;

import java.util.*;

/**
 * 10.2 철자 순서만 바꾼 문자열이 서로 인접하도록 문자열 배열을 정렬하는 메서드를 작성하라.
 *
 * (4E)
 *
 * (6E)
 * 10.2 Group Anagrams: Write a method to sort an array of strings so that the anagrams are next to each other.
 *
 *                      Hint #177.
 *                      Hint #182.
 *                      Hint #263.
 *                      Hint #342.
 */

/**
 * Array Sorting 이므로 가장 기본적이고 쉬운 방법이 Arrays.sort() 를 이용하면 될 것이다.
 *  --> char[] sorting 을 기본 제공하므로 다른 타입의 배열을 정렬하기 원하면 Comparator 만 만들어서 제공하면 된다.
 *  1) Comparator 와 내부에서는 문자열 sorting 기능을 이용
 *  2) HashMap 에 정렬된 문자열을 키로하여 동일한 키를 가지는 값들을 Chaining(LinkedList)로 Collect후 기존 배열에 차례대로 추가하면 된다.
 */
public class SortingSearching02 {
    //--------------------------------------------------------------------------------
    // Solution #1. Arrays.sort() + Comparator
    //--------------------------------------------------------------------------------
    private static class AnagramComparator implements Comparator<String>{
        public String sortChars(String s) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static void sort01(String[] array) {
        Arrays.sort(array, new AnagramComparator());    // Time: O(n log(n))
    }


    //--------------------------------------------------------------------------------
    // Solution #2. Buffer (a modification of Bucket Sort)
    //--------------------------------------------------------------------------------
    private static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void sort02(String[] strings) {
        // HashMap with Chaining

        /*
        HashMapList<String, String> map = new HashMapList<String, String>();

        for (String s : array) {
            String key = sortChars(s);
            map.put(key, s);
        }
        */

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        // classify
        for (String str : strings) {
            String key = sortString(str);
            ArrayList<String> list;

            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }

            list.add(str);
        }

        int index = 0;
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);

            for (String str : list) {
                strings[index++] = str;
            }
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        String[] array01 = new String[array.length];
        String[] array02 = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            array01[i] = array02[i] = array[i];
        }

        // Comparator
        System.out.println("array01: " + AssortedMethods.stringArrayToString(array01));
        sort01(array01);
        System.out.println("         " + AssortedMethods.stringArrayToString(array01));

        // Buffer: HashMap with Chaining
        System.out.println("array02: " + AssortedMethods.stringArrayToString(array02));
        sort02(array02);
        System.out.println("         " + AssortedMethods.stringArrayToString(array02));
    }
}
