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
 *                  Hints: #27, #59, #78
 */

/**
 * Java 가 제공하는 기본 Stack 기능을 확장하여 2가지 방법 존재
 *  1) min 값 전용 스택을 내부에서 관리 --> 총 2개의 스택 이용 --> space 소비 --> 그러나 일반적으로 2)번 보다 공간소비는 적을수 있다.
 *  2) 스택은 하나 사용하나, 모든 Element가 min 값을 가지도록 한다 --> 역시 space 소비
 */
public class StackQueue02 {
    /**
     * The thing with minimum is that they don't change very often.
     * We can implement this by having each node in the stack keep track of the minimum beneath itself.
     */

    //--------------------------------------------------------------------------------
    // Solution #1: To have a single int value, minValue,
    //              that's a member of the Stack class.
    //              --> When minValue is popped from the stack,
    //                  we search through the stack to find the new minimum.
    //                  Unfortunately, this would break the constraint that
    //                  push and pop operate in O(1) time
    //--------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------
    // Solution #2: Keeping track of the min for every single element.
    //              --> If we have a large stack, we waste a lot of space.
    //--------------------------------------------------------------------------------
    // New Element Type
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
//            int newMin = value < min() ? value : min();
            int newMin = Math.min(value, min());

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
    // Solution #3: Using an additional stack which keeps track of the mins.
    //              --> this might be more space efficient.
    //--------------------------------------------------------------------------------
    // Additional Stack
    public static class StackWithMin02 extends Stack<Integer> {
        private Stack<Integer> minStack;

        public StackWithMin02() {
            minStack = new Stack<Integer>();
        }

        public void push(int value) {
//            if (isFull()) {
//                throw OverflowException();
//            }

            if (value <= min())
                minStack.push(value);

            super.push(value);
        }

        public Integer pop() {
//            if (isEmpty()) {
//                throw UnderflowException();
//            }

            int value = super.pop();
            if (value == min())
                minStack.pop();

            return value;
        }

        public Integer min() {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            }

            return minStack.peek();
        }
    }


    public static void main(String[] args) {
        StackWithMin01 stack01 = new StackWithMin01();
        StackWithMin02 stack02 = new StackWithMin02();

        // Alternative 1
        //  - push (5 - 6 - 3 - 7)
        //  - pop() - pop()

        // Alternative 2
        for (int i = 0; i < 15; i++) {
            int value = AssortedMethods.randomIntInRange(0, 100);
            stack01.push(value);
            stack02.push(value);
            System.out.print(value + ", ");
        }
        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.println("Popped: " + stack01.pop().value + ", " + stack02.pop());
            System.out.println("New min: " + stack01.min() + ", " + stack02.min());
        }

        // Alternative 3
        int[] array = {2, 1, 3, 1};

        for (int value : array) {
            stack01.push(value);
            stack02.push(value);
            System.out.print(value + ", ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped: " + stack01.pop().value + ", " + stack02.pop());
            System.out.println("New min: " + stack01.min() + ", " + stack02.min());
        }
    }
}
