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

/**
 * 방법
 *  1) 2개의 리스트 생성 --> 하나로 머지하는 전략: 리스트를 순회하면서 x보다 작은 값을 가지는 리스트와 같거나 큰 값을 가지는 리스트 생성후 --> 합병
 *      - 4개의 포인터를 사용하여, end 포인터로 노드를 삽입 --> 두 개의 포인터를 연결 --> 원래 리스트의 순서 유지 가능. 결과 리스트 생성위해 포인터 이동 불필요
 *      - 2개의 포인터 사용하면 start 포인터 앞쪽으로 노트를 삽입 --> 왼쪽 포인터를 끝까지 이동후 포인터 연결(리스트 순회 시간이 추가로 필요) --> 리스트 순서가 역배요
 *  2) 하나의 리스트 생성 전략 --> 머지 없음: 원래 리스트를 포인터만 변경해서 생성
 *      - 원래 노드의 포인터만 변경해서 신규 리스트 생성 --> head 에는 앞쪽으로, tail에는 뒤쪽으로 노드 삽입
 *
 * ==> 전체 리스트에서 정렬이 필요한 경우는 리스트를 분리하여 작업후 조인하는게 좋다. 즉, 1-1 번 방법이 원래 리스트의 순서 유지 가능
 *
 * 내 의견
 *  - Time Complexity: O(N) --> 전체 노드를 탐색해야 하므로, 리스트 길이에 따라 실행 시간 더 걸린다.
 *  - Space Complexity: O(1) --> 리스트 길이에 따라 필요한 메모리 공간이 변하지 않으므로 constant time
 */
public class LinkedList04 {
    /*
        기본 전략:
        - 전체 리스트를 Traverse 하면서,
        - x보다 작은(less than) 노드는 before 리스트에,
        - x보다 크거나 같은 (greater than or equal to) 노드는 after 리스트에 추가한 후,
        - 리스트가 종료되면 두 리스트를 연결하여 리턴한다.

        참고:
        - x(partition/pivot element) 는 x 보다 작은 노드들 뒤에만 존재하면 된다.
        - Order 유지 여부
     */


    //--------------------------------------------------------------------------------
    // Solution #1. 4-References (beforeStart, beforeEnd, afterStart, afterEnd) && Concatenation
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(1)
    //
    //              ==> //TODO: 두 리스트 모두 원래 리스트의 순서가 유지된다. --> Original Order(O)
    //--------------------------------------------------------------------------------
    // 2개의 리스트를 4개의 포인터로 표현 --> 4개의 참조를 가지고 하나의 리스트를 생성
    public static LinkedListNode partition01(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;
        LinkedListNode current = node;

        // divide/partition
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

        // merge
        if (beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }


    //--------------------------------------------------------------------------------
    // Solution #2. 2-References (beforeStart, afterStart) && Concatenation
    //              - Time Complexity: O(n + n/2) --> O(n)
    //              - Space Complexity: O(1)
    //              ==> //TODO: 두 리스트 모두 원래 리스트의 역순으로 배열된다.
    //--------------------------------------------------------------------------------
    // 2개의 리스트를 2개의 포인터로 표현 --> 2개의 참조를 가지고 하나의 리스트를 생성
    public static LinkedListNode partition02(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;
        LinkedListNode current = node;

        // divide/partition
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

        // merge
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
    // Solution #3. 2-References (head, tail)
    //              - Time Complexity: O(n)
    //              - Space Complexity: O(1)
    //              ==> //TODO: head쪽은 역순, tail쪽은 원래 순서가 유지된다. 장점은 concatenation 불필요 --> Original Order(X)
    //--------------------------------------------------------------------------------
    // 기존 리스트를 이용하여 포인터만 변경하여 리스트 생성
    public static LinkedListNode partition03(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        LinkedListNode current = node;

        // divide/partition
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

        // no merge needed

        return head;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static void runPartition(LinkedListNode head, int x) {
        LinkedListNode p01 = partition01(head.clone(), x);
        System.out.println("\tpartition01(" + x + "): " + p01.printForward());

        LinkedListNode p02 = partition02(head.clone(), x);
        System.out.println("\tpartition02(" + x + "): " + p02.printForward());

        LinkedListNode p03 = partition03(head.clone(), x);
        System.out.println("\tpartition03(" + x + "): " + p03.printForward());
    }

    public static void main(String[] args) {
        //--------------------------------------------------------------------------------
        // Sample 01
        int[] vals01 = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head01 = new LinkedListNode(vals01[0], null, null);
        LinkedListNode current01 = head01;

        for (int i = 1; i < vals01.length; i++) {
            current01 = new LinkedListNode(vals01[i], null, current01);
        }
        System.out.println("Sample01: " + head01.printForward());

        // Partition
        runPartition(head01, 5);


        //--------------------------------------------------------------------------------
        // Sample 02
        int[] vals02 = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head02 = new LinkedListNode(vals02[0], null, null);
        LinkedListNode current02 = head02;

        for (int i = 1; i < vals02.length; i++) {
            current02 = new LinkedListNode(vals02[i], null, current02);
        }
        System.out.println("Sample02: " + head02.printForward());

        // Partition
        runPartition(head02, 5);


        //--------------------------------------------------------------------------------
        // Sample 03
        int[] vals03 = {33, 9, 2, 3, 10, 10389, 838, 874578, 5};
        LinkedListNode head03 = new LinkedListNode(vals03[0], null, null);
        LinkedListNode current03 = head03;

        for (int i = 1; i < vals03.length; i++) {
            current03 = new LinkedListNode(vals03[i], null, current03);
        }
        System.out.println("Sample03: " + head03.printForward());

        // Partition
        runPartition(head03, 3);


        //--------------------------------------------------------------------------------
        // Sample 04
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            int data = i >= length / 2 ? length - i - 1 : i;
            nodes[i] = new LinkedListNode(data, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1)
                nodes[i].setNext(nodes[i + 1]);

            if (i > 0)
                nodes[i].setPrevious(nodes[i - 1]);
        }

        LinkedListNode head04 = nodes[0];
        System.out.println("Sample04: " + head04.printForward());

        // Partition
        runPartition(head04, 5);
    }
}