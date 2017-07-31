package ch03stackqueue;

import java.util.ArrayList;

/**
 * 3.3 접시 무더기를 떠올려 보자.
 *     접시를 너무 높이 쌓으면, 넘어질 것이다.
 *     그러므로 현실에서는 무더기 높이가 특정한 수준 이상으로 높아지면 새로운 무더기를 만든다.
 *     이것을 흉내내는 자료구조 SetOfStacks 를 구현해 보라.
 *     SetOfStacks 는 여러 스택으로 구성되어야 하며, 이전 스택이 지정된 용량을 초과하는 경우 새로운 스택을 생성해야 한다.
 *     SetOfStacks.push() 와 SetOfStacks.pop() 은 스택이 하나인 경우와 동일하게 동작해야 한다.
 *     (다시 말해, pop() 은 정확히 하나의 스택이 있을 때와 동일한 값을 반환해야 한다).
 *
 *     연관 문제
 *      특정한 하위 스택에 대해서 pop 을 수행하는 popAt(int index) 함수를 구현하라.
 *
 * (4E)
 * 3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *     Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 *     Implement a data structure SetOfStacks that mimics this.
 *     SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 *     SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 *     (that is, pop() should return the same values as it would if there were just a single stack).
 *
 *     FOLLOW UP
 *      Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *
 * (6E)
 * 3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *                      Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 *                      Implement a data structure SetOfStacks that mimics this.
 *                      SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 *                      SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 *                      (that is, pop() should return the same values as it would if there were just a single stack).
 *
 *                      FOLLOW UP
 *                          Implement a function popAt(int index) which performs a pop operation on a specific substack.
 *
 *                      Hints: #64, #81
 */
public class StackQueue03 {
    private static class Node<T> {
        public Node<T> above;
        public Node<T> below;
        public T value;

        public Node(T v) {
            value = v;
        }
    }

    private static class Stack<T> {
        private Node<T> top;
        private Node<T> bottom;
        private int capacity;
        private int size;

        public Stack(int cap) {
            capacity = cap;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size >= capacity;
        }

        private void join(Node<T> above, Node<T> below) {
            if(above != null) above.below = below;
            if(below != null) below.above = above;
        }

        public boolean push(T v) {
            if (isFull()) {
                return false;
            }

            size++;
            Node<T> n = new Node<T>(v);

            join(n, top);
            top = n;

            if (size == 1) {
                bottom = n;
            }

            return true;
        }
        public T pop() {
            if (isEmpty()) {    // or top == null
                return null;    // or throw EmptyStackException();
            }

            size--;
            T v = top.value;

            Node<T> newTop = top.below;
            top.below = null;
            newTop.above = null;
            top = newTop;

            return v;
        }

        public T bottom() {
            if (isEmpty()) {
                return null;    // or throw EmptyStackException();
            }

            Node<T> tmp = bottom;

            size--;
            bottom = bottom.above;
            if (bottom != null) {
                bottom.below = null;
            }

            tmp.above = null;
            return tmp.value;
        }
    }

    private static class SetOfStacks<T> {
        private ArrayList<Stack<T>> stacks;
        private int capacity;

        public SetOfStacks(int capacity) {
            stacks = new ArrayList<Stack<T>>();
            this.capacity = capacity;
        }

        private Stack<T> getLastStack() {
            if (stacks.size() == 0) {
                return null;
            }

            return stacks.get(stacks.size() - 1);
        }

        //
        public boolean isEmpty() {
            Stack<T> last = getLastStack();

            // (stacks.size() == 0 || last == null)
            return last == null || (stacks.size() == 1 && last.isEmpty());
        }

        //
        public void push(T v) {
            Stack<T> last = getLastStack();

            if (last != null && !last.isFull()) {
                last.push(v);
            } else {
                Stack<T> stack = new Stack<T>(capacity);
                stack.push(v);
                stacks.add(stack);
            }
        }

        //
        public T pop() {
            if (isEmpty()) {
                return null;    // or throws EmptyStackException();
            }

            Stack<T> last = getLastStack();
            T v = last.pop();

            if (last.isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }

            return v;
        }

        //
        private T leftShift(int index, boolean removeTop) {
            Stack<T> stack = stacks.get(index);

            if (stack == null) {
                return null;    // or throw IndexOutOfBoundException();
            }

            T removedItem;
            if (removeTop) {
                removedItem = stack.pop();
            } else {
                removedItem = stack.bottom();
            }

            if (stack.isEmpty()) {
                stacks.remove(index);
            } else if (index + 1 < stacks.size()){
                T v = leftShift(index + 1, false);
                stack.push(v);
            }

            return removedItem;
        }

        public T pop(int index) {
            return leftShift(index, true);
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks(5);

        for (int i = 0; i < 34; i++) {
            set.push(i);
        }

        for (int i = 0; i < 35; i++) {
            set.pop();
        }
    }
}
