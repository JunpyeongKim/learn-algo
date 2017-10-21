package ch02linkedlist;

import lib.AssortedMethods;
import lib.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.1 다음의 비정렬(unsorted) 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 *
 *     연관 문제
 *      임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?
 *
 * (4E)
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 *
 *     FOLLOW UP
 *      How would you solve this problem if a temporary buffer is not allowed?
 *
 * (6E)
 * 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
 *
 *                  FOLLOW UP
 *                      How would you solve this problem if a temporary buffer is not allowed?
 *
 *                  Hints: #9, #40
 */
public class LinkedList01 {
    //--------------------------------------------------------------------------------
    // Solution #1. Buffer(HashSet/HashMap) + previous + current(to be deleted)
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(n)
    //--------------------------------------------------------------------------------
    public static void deleteDups01(LinkedListNode head) {
        if (head == null)
            return;

        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode current = head;
        LinkedListNode previous = null;

        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }

            current = current.next;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #2. No Buffer + current + runner(to be deleted)
    //              - Time Complexity: O((n-1)*(n-1)) --> O(n^2)
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static void deleteDups02(LinkedListNode head) {
        if (head == null)
            return;

        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #3. No Buffer + runner + previous + current(to be deleted)
    //              - Time Complexity: O(n + (1 + 2 + ... + n-1)) --> (n^2)
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static void deleteDups03(LinkedListNode head) {
        if (head == null)
            return;

        LinkedListNode previous = head;
        LinkedListNode current = head.next;

        while (current != null) {
            LinkedListNode runner = head;

            while (runner != current) {
                if (runner.data == current.data) {
                    previous.next = current.next;
                    current = current.next;
                    break;
                }

                runner = runner.next;
            }

            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Sample 01
       LinkedListNode sample01 = AssortedMethods.randomLinkedList(1000, 0, 2);

        // Sample 02
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode sample02 = first;
        LinkedListNode second = first;

        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }

        LinkedListNode[] data = {sample01, sample02};

        for (LinkedListNode head : data) {
            System.out.println("Sample: " + head.printForward());
            
            // Buffer
            LinkedListNode clone = head.clone();
            deleteDups01(clone);
            System.out.println("---> HashSet: " + clone.printForward());
    
    
            // Runner 01
            clone = head.clone();
            deleteDups02(clone);
            System.out.println("---> Runner01 + No Buffer: " + clone.printForward());
    
    
            // Runner 02
            clone = head.clone();
            deleteDups03(clone);
            System.out.println("---> Runner01 + No Buffer: " + clone.printForward());

            System.out.println();
        }
    }
}