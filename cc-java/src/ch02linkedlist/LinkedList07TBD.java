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
public class LinkedList07TBD {
    public class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    public Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(head, true);
        } else if (length == 2) {
            return new Result(head, head.getData() == head.getNext().getData());
        }

        //TODO:
        Result result = isPalindromeRecurse(head.getNext(), length - 2);
        return result;
    }

    public boolean isPalindrome(LinkedListNode head) {
        int size = 0;
        LinkedListNode current = head;

        while (current != null) {
            size++;
            current = current.getNext();
        }

        Result p = isPalindromeRecurse(head, size);

        return p.result;
    }

    public boolean isPalindrome02(LinkedListNode head) {
        LinkedListNode fast;
        return false;   //TODO:
    }

    public static void main(String[] args) {
        //TODO: make a list


        Question07TBD q = new Question07TBD();
        System.out.println(q.isPalindrome(null));
    }
}
