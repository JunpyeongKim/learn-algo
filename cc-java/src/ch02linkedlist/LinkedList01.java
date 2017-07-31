package ch02linkedlist;

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

/**
 * 방법
 *  1) 버퍼를 이용하여 중복된 값이 존재하는지 체크 --> 값만 체크하면 되므로 Set 을 이용한다.
 *  2) runner 를 이용한 방법인데 2가지가 존재한다.
 *      A) current~null 까지 runner 를 움직인다.
 *      B) head~current 까지 runner 를 움직인다.
 */
public class LinkedList01 {
    //--------------------------------------------------------------------------------
    // Solution #1. Buffer: Hashtable, HashSet, HashMap
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(n)
    //--------------------------------------------------------------------------------
    // Buffer - HashSet 사용
    // Complexity: ???
    // Time Complexity: O(N) <-- 리스트 한번 순회
    // Space Complexity: O(N) <-- 중복이 없다면 리스트의 길이만큼 버퍼 필요
    public static void deleteDups01(LinkedListNode head) {
        if (head == null)
            return;

        Set<Integer> set = new HashSet<Integer>();
        LinkedListNode current = head;
        LinkedListNode previous = null;

        while (current != null) {
            if (set.contains(current.getData())) {
                previous.next = current.next;
            } else {
                set.add(current.getData());
                previous = current;
            }

            current = current.next;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #2. Runner 01 = current + runner
    //              - Time Complexity: O(n^2)
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    // 앞선 runner 사용 --> runner 가 제거 대상 --> 즉, 앞으로 달리는 녀석이 제거 대상
    // runner 는 항상 current 다음부터 끝까지 달리기 시작
    // Complexity: ???
    // Time Complexity: O(N^2) <-- 루프가 2개 생기게 되므로
    // Space Complexity: O(1) <-- 리스트 길이에 의존하지 않으므로
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
    // Solution #3. Runner 02 = runner + previous + current
    //              - Time Complexity: O(n^2)
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    // 뒤따라오는 runner 사용 --> current 가 제거 대상 --> 즉, 앞으로 달리는 녀석이 제거 대상
    // runner 는 항상 head 부터 다시 달려온다.
    // Complexity: ???
    // Time Complexity: O(N) <-- 루프가 2개
    // Space Complexity: O(1) <-- 리스트 길이에 의존적이지 않으므로
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
//        LinkedListNode first = AssortedMethods.randomLinkedList(1000, 0, 2);

        // Sample 02
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;

        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }

        System.out.println("Original: " + head.printForward());

        // Buffer
        LinkedListNode clone01 = head.clone();
        System.out.println("Clone01: " + clone01.printForward());

        deleteDups01(clone01);
        System.out.println("\tClone01: " + clone01.printForward());


        // Runner 01
        LinkedListNode clone02 = head.clone();
        System.out.println("Clone02: " + clone02.printForward());

        deleteDups02(clone02);
        System.out.println("\tClone02: " + clone02.printForward());


        // Runner 02
        LinkedListNode clone03 = head.clone();
        System.out.println("Clone03: " + clone03.printForward());

        deleteDups03(clone03);
        System.out.println("\tClone03: " + clone03.printForward());
    }
}