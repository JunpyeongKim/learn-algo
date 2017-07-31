package ch05queue;

import lib.UnderflowException;

import java.util.Stack;

/**
 * Problem-2 How can you implement a queue using two stacks.
 */
public class Queue02<T> {
    private Stack<T> stack1;    // enqueue as rear
    private Stack<T> stack2;    // dequeue as front

    public Queue02() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    // Time Complexity: O(1)
    public void enqueue(T data) {
        stack1.push(data);
    }

    // Time Complexity: O(n)
    public T dequeue() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        if (stack2.isEmpty()) {
            // Need to optimize
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();    // EmptyStackException
    }

    // Optimized by transferring only n-1 elements from stack1 to stack2
    //          and pop the nth element from stack1
    //          and return that popped element.
    // Time Complexity: O(n)
    public T dequeueOptimized() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        if (stack2.isEmpty()) {
            // Need to optimize
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }

            // Optimized
            int size = stack1.size();
            while (!stack1.isEmpty()) {
                if (size == 1)
                    break;

                stack2.push(stack1.pop());
                size--;
            }

            return stack1.pop();
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public String toString() {
        //TODO:
        return null;
    }


    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        Queue02<Integer> queueWithTwoStacks = new Queue02<Integer>();

        System.out.println("init: ");   //TODO:

        queueWithTwoStacks.enqueue(1);
        queueWithTwoStacks.enqueue(2);
        queueWithTwoStacks.enqueue(3);
        queueWithTwoStacks.enqueue(4);
        queueWithTwoStacks.enqueue(5);

        System.out.println("Enqueue: ");    //TODO:

        while (!queueWithTwoStacks.isEmpty()) {
            System.out.println("Dequeue: " + queueWithTwoStacks.dequeue() + " ");
        }
    }
}
