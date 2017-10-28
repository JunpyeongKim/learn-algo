package ch02linkedlist;

import lib.LinkedListNode;

/**
 * 2.7 주어진 연결 리스트가 회문(palindrome)인지 검사하는 함수를 작성하라.
 *
 * (6E)
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 *
 *                 Hints: #5, #13, #29, #61, #101
 */
public class LinkedList07 {
    public class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #1: 역순 리스트 생성 --> 원본과 비교
    //TODO: Time Complexity: O(N + N) --> O(N), Space Complexity: O(N)
    //--------------------------------------------------------------------------------
    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinedListNode head = null;

        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;

            node = node.next;
        }

        return head;
    }

    private static boolean isEqual(LinkedListNode n1, LinkedListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) {
                return false;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return n1 == null && n2 == null;
    }

    public static boolean isPalindrome01(LinkedListNode head) {
        LinkedListNode reverse = reverseAndClone(head);
        return isEqual(head, reverse);
    }

    //--------------------------------------------------------------------------------
    // Solution #2: Slow-Fast Runner + Stack 이용
    //--------------------------------------------------------------------------------
    public static boolean isPalindrome02(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();

        // slow-fast runner 이용하여 이동
        while (fast != null && fast.next != null) {
            stack.push(slow.data);

            slow = slow.next;
            fast = fast.next.next;  // slow 의 2배로 이동
        }

        // 길이가 홀수인 경우 fast != null 이어서 중간값이 되므로 slow 처리 <-- 노드가 3개, 4개인 경우를 샘플로 알 수 있음
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.data) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    //--------------------------------------------------------------------------------
    // Solution #3: 별도 결과 클래스 정의 ????
    //--------------------------------------------------------------------------------
    static class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode n, boolean res) {
            node = n;
            result = res;
        }
    }

    private static int lengthOfList(LinkedListNode node) {
        int size = 0;

        while (n != null) {
            size++;
            n = n.next;
        }

        return size;
    }

    private static Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) {  // even
            return new Result(head, true);
        } else if (length == 1) {   // odd
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);
        res.node = res.node.next;

        return res;
    }

    //TODO: ???
    private static boolean isPalidrome03(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];

        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - 1 - i : i, null, null);
        }

        for (int i = 0; i < length; i++) {

        }


        Question07TBD q = new Question07TBD();
        System.out.println(q.isPalindrome(null));
    }
}
