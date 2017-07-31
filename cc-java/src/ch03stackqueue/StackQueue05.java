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

/**
 * Queue는 rear 에서 enqueue, front에서 dequeue 가 일어나므로 각 스택은 한가지 목적으로만 사용한다.
 * 그리고, 스택을 두번 거치면 FIFO 이 되므로 조건에도 부합된다.
 * 단, peek, dequeue 일때는 front 가 empty 인지 여부를 체크후 --> rear 에서 front 로 데이터를 옮길후 연산을 한다.
 */
public class StackQueue05 {
    private static class MyQueue<T> {
        Stack<T> stackRear, stackFront;

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

        public T peek() {
            shiftStacks();
            return stackFront.peek();
        }

        public T remove() {
            shiftStacks();
            return stackFront.pop();
        }
    }


    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        Queue<Integer> testQueue = new LinkedList<Integer>();

        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);

            if (choice <= 5) {

            } else if (testQueue.size() > 0) {

            }

            if (testQueue.size() == myQueue.size()) {
                //
            } else {
                //
            }
        }
    }
}
