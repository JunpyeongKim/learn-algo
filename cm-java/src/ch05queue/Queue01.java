package ch05queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem-1 Give an algorithm for reversing a queue Q.
 *           To access the queue, you are only allowed to use the methods of queue ADT.
 */
public class Queue01 {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static <T> Queue<T> reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<T>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());   // dequeue --> push
        }

        while(!stack.isEmpty()) {
            queue.offer(stack.pop());   // pop --> enqueue
        }

        return queue;
    }


    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);

        reverse(queue);
        System.out.println(queue);
    }
}
