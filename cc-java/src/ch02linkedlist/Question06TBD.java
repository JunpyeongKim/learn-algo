package ch02linkedlist;

import lib.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.6 순환 연결 리스트 (circular linked list)가 주어졌을 때, 순환되는 부분의 첫 노드를 반환하는 알고리즘을 구하라.
 *
 * 2.5 (5E) Given a circular linked list,
 *     implement an algorithm which returns node at the beginning of the loop.
 *
 *     DEFINITION
 *      Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
 *                            so as to make a loop in the linked list.
 *
 *     EXAMPLE
 *      Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 *      Output: C
 *
 * 2.8 (6E) Loop Detection:
 *      Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 *
 *      DEFINITION
 *          Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 *          so as to make a loop in the linked list.
 *
 *      EXAMPLE
 *          Input: A -) B -) C -) 0 -) E - ) C [the same C as earlier]
 *          Output: C
 */
public class Question06TBD {

    //TODO:
    public static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head; // slow runner
        LinkedListNode fast = head; // fast runner

        if (fast == null || fast.next == null)
            return null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    // mine
    public static LinkedListNode findBeginning02(LinkedListNode head) {
        Set<LinkedListNode> set = new HashSet<LinkedListNode>();
        LinkedListNode current = head;

        while (current != null) {
            if (set.contains(current.next)) {
                return current.next;
            } else {
                set.add(current.next);
            }
            current = current.next;
        }

        return null;
    }


    public static void main(String[] args) {
        int list_length = 100;
        LinkedListNode[] nodes = new LinkedListNode[list_length];

        LinkedListNode loop = findBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle");
        } else {
            System.out.println(loop.data);
        }
    }
}
