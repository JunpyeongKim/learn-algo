package ch03stackqueue;

import lib.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 3.5 두 개의 스택을 사용하여 큐를 구현하는 MyQueue 클래스를 작성하라.
 *
 * (4E)
 * 3.5 Implement a MyQueue class which implements a queue using two stacks
 *
 * (6E)
 * 3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 *
 *                       Hints: #98, #114
 */
public class StackQueue05 {
    private static class MyQueue<T> {
        private Stack<T> stackRear;
        private Stack<T> stackFront;

        public MyQueue() {
            stackRear = new Stack<T>();
            stackFront = new Stack<T>();
        }

        public int size() {
            return stackRear.size() + stackFront.size();
        }

        public void add(T value) {
            stackRear.push(value);
        }

        private void shiftStacks() {
            if (stackFront.isEmpty()) {
                while (!stackRear.isEmpty()) {
                    stackFront.push(stackRear.pop());
                }
            }
        }

        public T remove() {
            shiftStacks();
            return stackFront.pop();
        }

        public T peek() {
            shiftStacks();
            return stackFront.peek();
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        Queue<Integer> testQueue = new LinkedList<Integer>();

        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);

            if (choice <= 5) {
                int element = AssortedMethods.randomIntInRange(1, 10);
                testQueue.add(element);
                myQueue.add(element);
                System.out.println("#" + i + " Enqueued " + element);
            } else if (testQueue.size() > 0) {
                int top1 = testQueue.remove();
                int top2 = myQueue.remove();
                if (top1 != top2) {
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                }
                System.out.println("#" + i + " Dequeued " + top1);
            }

            if (testQueue.size() == myQueue.size()) {
                if (testQueue.size() > 0 && testQueue.peek() != myQueue.peek()) {
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + testQueue.peek() + ", " + myQueue.peek() + " ******");
                }
            } else {
                System.out.println("******* FAILURE - DIFFERENT SIZES ******");
            }
        }
    }
}
