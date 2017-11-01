package ch03stackqueue;

import java.util.ArrayList;

/**
 * 3.3 접시 무더기를 떠올려 보자. 접시를 너무 높이 쌓으면, 넘어질 것이다. 
 *     그러므로 현실에서는 무더기 높이가 특정한 수준 이상으로 높아지면 새로운 무더기를 만든다.
 *     이것을 흉내내는 자료구조 SetOfStacks 를 구현해 보라.
 * 
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
        public T value;
        public Node<T> above;   // for popAt()
        public Node<T> below;   // for popAt()

        public Node(T v) {
            value = v;
        }
    }

    private static class Stack<T> {
        private int capacity;
        private int size;
        private Node<T> top;
        private Node<T> bottom;

        public Stack(int capacity) {
            this.capacity = capacity;
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

            // for popAt()
            join(n, top);
            top = n;

            if (size == 1) {
                bottom = n;
            }

            return true;
        }

        public T pop() throws EmptyStackException {
            if (isEmpty()) {    // or top == null
                throw new EmptyStackException();
            }

            size--;
            T v = top.value;

            // for popAt()
            Node<T> newTop = top.below;
            top.below = null;
            if (newTop != null)
                newTop.above = null;
            top = newTop;

            return v;
        }

        public T removeBottom() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            size--;

            Node<T> tmp = bottom;
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
        private int capacity;   // threshold

        // Constructor
        public SetOfStacks(int capacity) {
            stacks = new ArrayList<Stack<T>>();
            this.capacity = capacity;
        }

        // Private API
        private Stack<T> getLastStack() {
            int stackSize = stacks.size();

            if (stackSize == 0) {
                return null;
            }

            return stacks.get(stackSize - 1);
        }

        // Public API
        public boolean isEmpty() {
            Stack<T> last = getLastStack();

            return last == null || (stacks.size() == 1 && last.isEmpty());
        }

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

        public T pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            Stack<T> last = getLastStack();
            T v = last.pop();

            if (last.isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }

            return v;
        }

        // Additional Public API
        private T leftShift(int index, boolean removeTop) throws IndexOutOfBoundsException {
            Stack<T> stack = stacks.get(index);

            if (stack == null) {
                throw new IndexOutOfBoundsException();
            }

            T removedItem = null;

            try {
                removedItem = removeTop ? stack.pop() : stack.removeBottom();            

                if (stack.isEmpty()) {
                    stacks.remove(index);
                } else if (index + 1 < stacks.size()) { // right before the last stack
                    T v = leftShift(index + 1, false);
                    stack.push(v);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return removedItem;
        }

        public T popAt(int index) throws IndexOutOfBoundsException {
            return leftShift(index, true);
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int capacityPerStack = 5;   // threshold
        SetOfStacks set = new SetOfStacks(capacityPerStack);

        // Push
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }

        // PopAt
        System.out.println("popAt(1): " + set.popAt(1));    // 9

        // Pop
        try{
            for (int i = 0; i < 35; i++) {
                System.out.println("Popped #" + i + ": " + set.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
