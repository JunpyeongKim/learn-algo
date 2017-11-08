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
 *                      #177. How do you check if two words are anagrams of each other? 
 *                            Think about what the definition of "anagram" is. 
 *                            Explain it in your own words. 
 *                      #182. Two words are anagrams if they contain the same characters but in different orders.
 *                            How can you put characters in order? 
 *                      #263. Can you leverage a standard sorting algorithm? 
 *                      #342. Do you even need to truly "sort"? Or is just reorganizing the list sufficient?
 */
public class SortSearch02 {
    /*
    # Strategy
      - Group the strings such that the permutations(>>> anagrams) appear next to each other.
      --> No specific ordering of the words is required.
    
    # Permutation/Anagram : the same characters but in different orders
      - Count the occurrences of the distinct characters
      - Just sort the string
    */


    //--------------------------------------------------------------------------------
    // Solution #1: java.util.Arrays.sort() + Comparator
    //              - Time Complexity: O(n log(n))
    //              - This may be the best we can do for a general sorting algorithm
    //--------------------------------------------------------------------------------
    private static class AnagramComparator implements Comparator<String>{
        public String sortChars(String s) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // 표준 정렬 알고리즘(Merge Sort, Quick Sort)
            return new String(charArray);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static void sort01(String[] array) {
        Arrays.sort(array, new AnagramComparator());
    }


    //--------------------------------------------------------------------------------
    // Solution #2: Buffer(HashMap with Chaining) --> a modification of "Bucket Sort"
    //              - We don't actually need to fully sort the array
    //              --> We only need to group strings in the array by anagram
    //--------------------------------------------------------------------------------
    private static String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void sort02(String[] strings) {
        // HashMap with Chaining
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        // Group
        for (String str : strings) {
            String key = sortString(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            ArrayList<String> list = map.get(key);
            list.add(str);
        }

        // Convert
        int index = 0;
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);

            System.out.print("\n[debug] " + key + " - ");
            for (String str : list) {
                strings[index++] = str;
                System.out.print(str + ", ");
            }
        }
        System.out.println();
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

        // Arrays.sort + Comparator
        sort01(array[0]);
        System.out.println("---> Comparator: " + AssortedMethods.stringArrayToString(array[0]));

        // Bucket sort - HashMap with Chaining
        sort02(array[1]);
        System.out.println("---> Bucket sort: " + AssortedMethods.stringArrayToString(array[1]));
    }
}