package ch02linkedlist;

import lib.LinkedListNode;

/**
 * 2.4 x 값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라.
 *     x 보다 작은 값을 갖는 노드가 x와 같거나 더 큰 값을 가는 노드들보다 앞 쪽에 오도록 하면 된다.
 *
 * (6E)
 * 2.4 Partition: Write code to partition a linked list around a value x,
 *                such that all nodes less than x come before all nodes greater than or equal to x.
 *                If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 *                The partition element x can appear anywhere in the "right partition";
 *                it does not need to appear between the left and right partitions.
 *
 *                EXAMPLE
 *                  Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 *                  Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 *                Hints: #3, #24
 */
public class LinkedList04 {
    //--------------------------------------------------------------------------------
    // Solution #1. 4 References(beforeStart && beforeEnd, afterStart && afterEnd) && Concatenation && Original Order
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(1)
    //
    //              ==> Order 유지: 두 리스트 모두 원본 리스트의 순서가 유지된다.
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition01(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        LinkedListNode current = node;

        // Divide/Partition
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = null;

            if (current.data < x) {
                if (beforeStart == null) {
                    beforeStart = current;
                    beforeEnd = current;
                } else {
                    beforeEnd.next = current;
                    beforeEnd = current;
                }
            } else {
                if (afterStart == null) {
                    afterStart = current;
                    afterEnd = current;
                } else {
                    afterEnd.next = current;
                    afterEnd = current;
                }
            }

            current = next;
        }

        // Concatenate
        if (beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }


    //--------------------------------------------------------------------------------
    // Solution #2. 2 References (beforeStart, afterStart) && Concatenation && Reverse Order
    //              - Time Complexity: O(n + m) --> O(n), where m <= n
    //              - Space Complexity: O(1)
    //              ==> // Order 역순 : 두 리스트 모두 원본 리스트의 역순으로 배열된다.
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition02(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        LinkedListNode current = node;

        // Divide/Partition
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = null;

            if (current.data < x) {
                current.next = beforeStart;
                beforeStart = current;
            } else {
                current.next = afterStart;
                afterStart = current;
            }

            current = next;
        }

        // Concatenate
        if (beforeStart == null) {
            return afterStart;
        }

        LinkedListNode runner = beforeStart;
        while (runner.next != null) {
            runner = runner.next;
        }

        runner.next = afterStart;
        return beforeStart;
    }


    //--------------------------------------------------------------------------------
    // Solution #3. 2 References (head, tail) && Partially Original Order
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(1)
    //              ==> head쪽은 역순, tail쪽은 원래 순서가 유지
    //              ==> concatenation 불필요
    //--------------------------------------------------------------------------------
    public static LinkedListNode partition03(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        LinkedListNode current = node;

        // Divide/Parition
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = null;

            if (current.data < x) {
                current.next = head;
                head = current;
            } else {
                tail.next = current;
                tail = current;
            }

            current = next;
        }

        // No concatenation needed

        return head;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static void runPartition(LinkedListNode head, int x) {
        System.out.println("Partition by " + x + ": " + head.printForward());

        LinkedListNode p01 = partition01(head.clone(), x);
        System.out.println("---> partition01(): " + p01.printForward());

        LinkedListNode p02 = partition02(head.clone(), x);
        System.out.println("---> partition02(): " + p02.printForward());

        LinkedListNode p03 = partition03(head.clone(), x);
        System.out.println("---> partition03(): " + p03.printForward());
    }

    public static void main(String[] args) {
        // Sample 01~03
        int[][] vals = {
            {3,  5, 8, 5, 10, 2, 1},
            {1, 3, 7, 5, 2, 9, 4},
            {33, 9, 2, 3, 10, 10389, 838, 874578, 5}
            };

        LinkedListNode head;
        LinkedListNode current;

        for (int index = 0; index < vals.length; index++) {
            head = new LinkedListNode(vals[index][0], null, null);
            current = head;

            for (int i = 1; i < vals[index].length; i++) {
                current = new LinkedListNode(vals[index][i], null, current);
            }

            runPartition(head, 5);  // runPartition(head, 3);
        }


        // Sample 04
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];

        for (int i = 0; i < length; i++) {
            int data = i >= length / 2 ? length - 1 - i : i;
            nodes[i] = new LinkedListNode(data, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1)
                nodes[i].setNext(nodes[i + 1]);

            if (i > 0)
                nodes[i].setPrevious(nodes[i - 1]);
        }

        head = nodes[0];

        runPartition(head, 5);
    }
}