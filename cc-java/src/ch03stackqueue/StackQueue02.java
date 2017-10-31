package ch03stackqueue;

import lib.AssortedMethods;

import java.util.Stack;

/**
 * 3.2 push와 pop의 두 가지 연산뿐 아니라, 최소값을 갖는 원소를 반환하는 min 연산을 갖춘 스택은 어떻게 구현할 수 있겠는가?
 *     Push, pop 그리고 min 은 공히 O(1) 시간에 처리되어야 한다.
 *
 * (4E)
 * 3.2 How would you design a stack which, in addition to push and pop, also has a function min which
 *     returns the minimum element?
 *     Push, pop and min should all operate in O(1) time.
 *
 * (6E)
 * 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min which
 *                returns the minimum element?
 *                Push, pop and min should all operate in O(1) time.
 *
 *                Hints: #27, #59, #78
 */
public class StackQueue02 {
    //--------------------------------------------------------------------------------
    // Solution #0: To have a single int value, minValue, that's a member of the Stack class.
    //              --> When minValue is popped from the stack, we search through the stack to find the new minimum.
    //                  Unfortunately, this would break the constraint that push and pop operate in O(1) time
    //--------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------
    // Solution #1: Keeping track of the min for every single element.
    //              --> If we have a large stack, we waste a lot of space.
    //--------------------------------------------------------------------------------
    public static class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public static class StackWithMin01 extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());    // value < min() ? value : min();

            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            }

            return peek().min;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #2: Using an additional stack which keeps track of the mins.
    //              --> this might be more space efficient.
    //--------------------------------------------------------------------------------
    public static class StackWithMin02 extends Stack<Integer> {
        private Stack<Integer> minStack;

        public StackWithMin02() {
            minStack = new Stack<Integer>();
        }

        public void push(int value) {
            if (value <= min())
                minStack.push(value);

            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min())
                minStack.pop();

            return value;
        }

        public int min() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            }

            return minStack.peek();
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        StackWithMin01 stack01 = new StackWithMin01();  // NodeWithMain
        StackWithMin02 stack02 = new StackWithMin02();  // Another Stack

        // Sample 01
        int[] array = {2, 1, 3, 1};

        System.out.print("Sample01: Bottom ---> ");
        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            stack01.push(value);
            stack02.push(value);

            System.out.print(value);
            if (i != array.length - 1)
                System.out.print(", ");
        }
        System.out.println(" <--- Top");

        for (int i = 0; i < array.length; i++) {
            System.out.println("----------------");
            System.out.println("Old min: " + stack01.min() + ", " + stack02.min());
            System.out.println("Popped: " + stack01.pop().value + ", " + stack02.pop());
            System.out.println("New min: " + stack01.min() + ", " + stack02.min());
        }


        // Sample 02
        System.out.println();
        System.out.print("Sample02: Bottom ---> ");
        for (int i = 0; i < 15; i++) {
            int value = AssortedMethods.randomIntInRange(0, 100);
            stack01.push(value);
            stack02.push(value);

            System.out.print(value);
            if (i != 15 - 1)
                System.out.print(", ");
        }
        System.out.println(" <--- Top");

        for (int i = 0; i < 15; i++) {
            System.out.println("----------------");
            System.out.println("Old min: " + stack01.min() + ", " + stack02.min());
            System.out.println("Popped: " + stack01.pop().value + ", " + stack02.pop());
            System.out.println("New min: " + stack01.min() + ", " + stack02.min());
        }
    }
}
