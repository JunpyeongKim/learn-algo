package ch02linkedlist;

import lib.LinkedListNode;

import java.util.Stack;

/**
 * 2.5 연결 리스트로 표현된 두 개의 수가 있다고 하자. 리스트의 각 노드는 해당 수의 각 자릿수를 표현한다. 이때 자릿수들은 역순으로
 *     배열되는데, 1의 자릿수가 리스트의 맨 앞에 오도록 배열된다는 뜻이다. 이 두 수를 더하여 그 합을 연결 리스트로 반환하는 함수를 작성하라.
 *
 *     연관문제:
 *      각 자릿수가 정상적으로 배열된다고 가정하고 구현해 보자.
 *
 * 2.4 (5E)
 *      You have two numbers represented by a linked list, where each node contains a single digit.
 *      The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 *     Write a function that adds the two numbers and returns the sum as a linked list.
 *
 *     EXAMPLE
 *      Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 *      Output: 8 -> 0 -> 8
 *
 *     FOLLOW UP
 *      Suppose the digits are stored in forward order. Repeat the above problem.
 *      Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 *      Output: 9 - > 1 - > 2. That is, 912.
 *
 * 2.5 (6E) Sum Lists:
 *      You have two numbers represented by a linked list, where each node contains a single digit.
 *      The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 *     Write a function that adds the two numbers and returns the sum as a linked list.
 *
 *     EXAMPLE
 *      Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 *      Output: 2 -> 1 -> 9. That is, 912.
 *
 *     FOLLOW UP
 *      Suppose the digits are stored in forward order. Repeat the above problem.
 *      Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 *      Output: 9 - > 1 - > 2. That is, 912.
 */
public class Question05TBD {
    public static Integer reverse(LinkedListNode node) {
        Stack<Integer> stack = new Stack<Integer>();

        // reverse
        LinkedListNode current = node;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return Integer.parseInt(sb.toString());
    }

    public static LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null)
            return null;

        int i1 = reverse(l1).intValue();
        int i2 = reverse(l2).intValue();
        String strSum = String.valueOf(i1 + i2);
        char[] array = strSum.toCharArray();

//        List<Integer> list = Arrays.asList(array);
        return null;    //TODO:
    }

    public static void main(String[] args) {

    }
}
