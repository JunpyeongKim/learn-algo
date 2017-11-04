package ch10sortsearch;

import lib.AssortedMethods;
import lib.HashMapList;

import java.util.*;

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

/**
 * Array Sorting 이므로 가장 기본적이고 쉬운 방법이 Arrays.sort() 를 이용하면 될 것이다.
 *  --> char[] sorting 을 기본 제공하므로 다른 타입의 배열을 정렬하기 원하면 Comparator 만 만들어서 제공하면 된다.
 *  1) Comparator 와 내부에서는 문자열 sorting 기능을 이용
 *  2) HashMap 에 정렬된 문자열을 키로하여 동일한 키를 가지는 값들을 Chaining(LinkedList)로 Collect후 기존 배열에 차례대로 추가하면 된다.
 */
public class SortingSearching02 {
    // Common Concept
    // ---> Permutation(>>> Anagram)이므로 ---> String을 Sorting하면, 동일한 String이 나와야한다.


    //--------------------------------------------------------------------------------
    // Solution #1. java.util.Arrays.sort() + Comparator
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
    // Solution #2. Buffer (a modification of Bucket Sort) - HashMap with Chaining
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
                map.put(key, list);
            }

            list.add(str);
        }

        int index = 0;
        for (String key : map.keySet()) {
            // System.out.println("key - " + key);
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
        String[][] array = {
            {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"},
            {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"}
        };
        System.out.println(AssortedMethods.stringArrayToString(array[0]));

        // Comparator
        sort01(array[0]);
        System.out.println("---> Comparator: " + AssortedMethods.stringArrayToString(array[0]));

        // Buffer: HashMap with Chaining
        sort02(array[1]);
        System.out.println("---> Buffer: " + AssortedMethods.stringArrayToString(array[1]));
    }
}
