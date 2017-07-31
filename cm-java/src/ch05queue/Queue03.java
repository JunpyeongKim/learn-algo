package ch05queue;

import lib.UnderflowException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-3 Show how can you efficiently implement one stack using two queues.
 *           Analyze the running time of the stack operation.
 */
public class Queue03<E> {
    private Queue<E> queue1;    // push
    private Queue<E> queue2;    // pop

    public Queue03() {
        queue1 = new LinkedList<E>();
        queue2 = new LinkedList<E>();
    }

    // Time Complexity: O(1)
    public void push(E data) {
        if (!queue1.isEmpty()) {
            queue1.offer(data);
        } else {
            queue2.offer(data);
        }
    }

    // Time Complexity: O(n)
    public E pop() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        int size, i = 0;
        if (!queue2.isEmpty()) {
            size = queue2.size();
            while (i < size - 1) {
                queue1.offer(queue2.poll());
                i++;
            }

            return queue2.poll();
        } else {
            size = queue1.size();
            while (i < size - 1) {
                queue2.offer(queue1.poll());
                i++;
            }

            return queue1.poll();
        }
    }

    public boolean isEmpty() {
        return (queue1.isEmpty() && queue2.isEmpty());
    }

    public String toString() {
        if (queue1.isEmpty()) {
            return queue2.toString();
        } else {
            return queue1.toString();
        }
    }


    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        Queue03<Integer> stackWithTwoQueues = new Queue03<Integer>();
        System.out.println("init: " + stackWithTwoQueues);

        stackWithTwoQueues.push(1);
        stackWithTwoQueues.push(2);
        stackWithTwoQueues.push(3);
        stackWithTwoQueues.push(4);
        stackWithTwoQueues.push(5);
        System.out.println("push(): " + stackWithTwoQueues);

        while (!stackWithTwoQueues.isEmpty()) {
            System.out.println("pop(): " + stackWithTwoQueues.pop());
        }
    }
}
