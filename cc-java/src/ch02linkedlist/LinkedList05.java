package ch02linkedlist;

import lib.LinkedListNode;

import java.util.Stack;

/**
 * 2.5 연결 리스트로 표현된 두 개의 수가 있다고 하자.리스트의 각 노드는 해당 수의 자릿수를 표현한다.
 *     이때 자릿수들은 역순으로 배열되는데, 1의 자릿수가 리스트의 맨 앞에 오도록 배열된다는 뜻이다.
 *     이 두 수를 더하여 그 합을 연결 리스트로 반환하는 함수를 작성하라.
 *
 *     - 예
 *          입력: (7->1->6) + (5->9->2), 즉 617 + 295
 *          출력: 2->1->9, 즉 912
 *
 *     - 연관 문제
 *          각 자릿수가 정상적으로 배열된다고 가정하고 구현해 보자.
 *       - 예
 *          입력: (6->1->7) + (2->9->5), 즉 617 + 295
 *          출력: 9->1->2, 즉 912
 *
 * (5E)
 * 2.4 You have two numbers represented by a linked list, where each node contains a single digit.
 *     The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 *     Write a function that adds the two numbers and returns the sum as a linked list.
 *
 *     EXAMPLE
 *      Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 *      Output: 8 -> 0 -> 8
 *
 * (6E)
 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
 *                The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 *                Write a function that adds the two numbers and returns the sum as a linked list.
 *
 *                EXAMPLE
 *                  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 *                  Output: 2 -> 1 -> 9. That is, 912.
 *
 *                FOLLOW UP
 *                  Suppose the digits are stored in forward order. Repeat the above problem.
 *                  Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 *                  Output: 9 -> 1 -> 2. That is, 912.
 *
 *                Hints: #7, #30, #71, #95, #109
 */
public class LinkedList05 {
    private static final Boolean FORWARD_ORDER = true;
    private static final Boolean REVERSE_ORDER = false;


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

    private static int linkedListToInt(LinkedListNode node, Boolean order) {
        int value = 0;

        if (order == REVERSE_ORDER) {
            // Reverse order
            if (node.next != null) {
                value = 10 * linkedListToInt(node.next, order);
            }
    
            return node.data + value;
        } else {
            // Forward order
            while (node != null) {
                value = value * 10 + node.data;
                node = node.next;
            }

            return value;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #1: Reverse Order 일 경우 사용 가능한 메소드
    //--------------------------------------------------------------------------------
    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next, 
                                            l2 == null ? null : l2.next, 
                                            value >= 10 ? 1 : 0);

            result.next = more;
        }

        return result;
    }

    //--------------------------------------------------------------------------------
    // Solution #2: Forward Order 일 경우 사용 --> 패딩도 해준다...이유는???
    //--------------------------------------------------------------------------------
    private static int length(LinkedListNode l) {
        if (l == null) {
            return 0;
        } else {
            return 1 + length(l.next);
        }
    }

    private static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        node.next = list;
        return node;
    }

    private static LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }

        return head;
    }

    static class PartialSum {
        public LinkedListNode sum;
        public int carry;
    }

    private static PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListHelper(l1.next, l2.next);

        int val = sum.carry + l1.data + l2.data;
        LinkedListNode result = insertBefore(sum.sum, val % 10);

        sum.sum = result;
        sum.carry = val / 10;
        return sum;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Sample 01
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);
        
        LinkedListNode list3R = addLists(lA1, lB1, 0);
        LinkedListNode list3F = addLists(lA1, lB1);
        
        System.out.println("  " + lA1.printForward());  //   9 -> 9 -> 9 -> NULL		
        System.out.println("+ " + lB1.printForward());	// + 1 -> 0 -> 0 -> NULL
        System.out.println("R= " + list3R.printForward());    //
        System.out.println("F= " + list3F.printForward());    //
        
        // Reverse: 999 + 1 = 1000
        int l1 = linkedListToInt(lA1, REVERSE_ORDER);
        int l2 = linkedListToInt(lB1, REVERSE_ORDER);
        int l3 = linkedListToInt(list3R, REVERSE_ORDER);
        System.out.println("---> R: " + l1 + " + " + l2 + " = " + (l1 + l2) + " equal ? " + l3);
        
        // Forward: 999 + 100 = 1099
        l1 = linkedListToInt(lA1, FORWARD_ORDER);
        l2 = linkedListToInt(lB1, FORWARD_ORDER);
        l3 = linkedListToInt(list3F, FORWARD_ORDER);
        System.out.println("---> F: " + l1 + " + " + l2 + " = " + (l1 + l2) + " equal ? " + l3);
        

        // Sample 02
        lA1 = new LinkedListNode(3, null, null);
		lA2 = new LinkedListNode(1, null, lA1);
		
		lB1 = new LinkedListNode(5, null, null);
		lB2 = new LinkedListNode(9, null, lB1);
        lB3 = new LinkedListNode(1, null, lB2);

        System.out.println("  " + lA1.printForward());  //   3 -> 1 -> NULL
        System.out.println("+ " + lB1.printForward());  // + 5 -> 9 -> 1 -> NULL
        
        // Reverse: 13 + 195 = 208
        l1 = linkedListToInt(lA1, REVERSE_ORDER);
		l2 = linkedListToInt(lB1, REVERSE_ORDER);
        System.out.println("---> R: " + l1 + " + " + l2 + " = " + (l1 + l2));
        
        // Forward: 31 + 591 = 602
        l1 = linkedListToInt(lA1, FORWARD_ORDER);
		l2 = linkedListToInt(lB1, FORWARD_ORDER);
        System.out.println("---> F: " + l1 + " + " + l2 + " = " + (l1 + l2));
    }
}
