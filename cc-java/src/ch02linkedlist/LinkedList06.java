package ch02linkedlist;

import lib.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.6 순환 연결 리스트 (circular linked list)가 주어졌을 때, 순환되는 부분의 첫 노드를 반환하는 알고리즘을 구하라.
 *      - 정의
 *          순환 연결리스트: 순환 연결리스트는 노드의 next 포인터가 앞선 노드들 가운데 어느 하나를 가리키도록 설정되어 있는 연결 리스트다
 *                       (망가진 연결리스트라고 볼 수 있다.)
 *      - 예
 *          입력: A -> B -> C -> D -> E -> C (E의 next 노드가 D 앞에 있는 C로 설정되어 있다.)
 *          출력: C
 *
 * (4E)
 * 2.5 Given a circular linked list,
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
 * (6E)
 * 2.8 Loop Detection: Given a circular linked list, 
 *                     implement an algorithm that returns the node at the beginning of the loop.
 *
 *                     DEFINITION
 *                      Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 *                      so as to make a loop in the linked list.
 *
 *                     EXAMPLE
 *                      Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 *                      Output: C
 */
public class LinkedList06 {

    //TODO:
    public static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head; // Slow runner
        LinkedListNode fast = head; // Fast runner

        if (fast == null || fast.next == null)
            return null;

        // Find
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // Check error
        if (fast == null || fast.next == null) {
            return null;
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


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int list_length = 100;
        LinkedListNode[] nodes = new LinkedListNode[list_length];

        // Create list
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i-1] : null);
        }

        // Create loop
        int k = 10;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = findBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle");
        } else {
            System.out.println(loop.data);
        }
    }
}
