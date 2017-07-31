package ch03stackqueue;

import lib.AssortedMethods;

import java.util.Stack;

/**
 * 3.6 큰 값이 위에 오도록 스택을 오름차순 정렬하는 프로그램을 작성하라.
 *     여벌 스택은 하나까지만 사용할 수 있고, 스택에 보관된 요소를 배열 등의 다른 자료구조로는 복사할 수 없다.
 *     스택은 push, pop, peek, isEmpty 의 네 가지 연산을 제공한다.
 *
 * (4E)
 * 3.6 Write a program to sort a stack in ascending order.
 *     You should not make any assumptions about how the stack is implemented.
 *     The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 *
 * (6E)
 * 3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top.
 *                 You can use an additional temporary stack,
 *                 but you may not copy the elements into any other data structure (such as an array).
 *                 The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 *                 Hints: #15, #32, #43
 */

/**
 * 추가 스택을 사용하면 ASC 를 원할 경우는 DESC로 정렬하고, DESC 를 원하면 ASC로 정렬하면된다.
 * --> mergeSort()의 경우 리버스를 하지 않고 원래 로직에서 ASC, DESC 원래 요구대로 정렬후 inStack 리턴해줘도 좋을 것같다.
 *
 *  1) 스택 하나를 사용할 경우 여러번의 푸시/팝 필요
 *  2) mergeSort 를 사용하면 여러개의 callstack과 callstack수 * 2개의 추가스택 만큼의 스택수가 필요하나 스택 리버스가 필요없을 수도 있다.
 */
public class StackQueue06 {
    // Ascending Order: The biggest items are on the top.
    // Descending Order: The smallest items are on the top.

    public static void sort(Stack<Integer> s, boolean isAscending) {
        Stack<Integer> t = new Stack<Integer>();

        while (!s.isEmpty()) {
            int data = s.pop();

            if (isAscending) { // ASC

                // DESC
                while (!t.isEmpty() && t.peek() < data) {
                    s.push(t.pop());
                }
            } else {    // DESC

                // ASC
                while (!t.isEmpty() && t.peek() > data) {
                    s.push(t.pop());
                }
            }

            t.push(data);
        }

        // Reverse
        while (!t.isEmpty()) {
            s.push(t.pop());
        }
    }

    public static Stack<Integer> mergeSort(Stack<Integer> inStack, boolean isAscending) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        // Divide
        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int count = 0;

        while (!inStack.isEmpty()) {
            count++;
            if (count % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }

        // Conquer
        left = mergeSort(left, isAscending);
        right = mergeSort(right, isAscending);
        int data;

        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.size() == 0) {
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                // ASC --> DESC
                data = isAscending ? left.pop() : right.pop();
                inStack.push(data);
            } else {
                // DESC --> ASC
                data = isAscending ? right.pop() : left.pop();
                inStack.push(data);
            }
        }

        // Reverse
        Stack<Integer> r = new Stack<Integer>();
        while (!inStack.isEmpty()) {
            r.push(inStack.pop());
        }

        return r;
    }

    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static Stack<Integer> makeStack() {
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < 10; i++) {
            int data = (int)((Math.random() * 1000) % 1000);
            s.push(data);
        }

        return s;
    }

    private static void checkStack(Stack<Integer> s, boolean isAscending) {
//        while (!s.isEmpty()) {
//            System.out.println(s.pop());
//        }


        int last = isAscending ? Integer.MAX_VALUE/*ascending*/ : Integer.MIN_VALUE/*descending*/;
        while (!s.isEmpty()) {
            int curr = s.pop();

            boolean error = isAscending ? curr > last/*ascending*/ : curr < last/*descending*/;
            if (error) {
                System.out.println("Error: " + last + " " + curr);
            }

            last = curr;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 100);
            s.push(r);
        }

        /*
        //--------------------------------------------------------------------------------
        System.out.println("Ascending Order:");

        sortAscending(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        //--------------------------------------------------------------------------------
        System.out.println("Descending Order:");

        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0, 100);
            s.push(r);
        }


        sortDescending(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        */

        s = makeStack();
        sort(s, true);  // ASC
        checkStack(s, true);

        s = makeStack();
        sort(s, false); //DESC
        checkStack(s, false);

        s = makeStack();
        s = mergeSort(s, true); // ASC
        checkStack(s, true);

        s = makeStack();
        s = mergeSort(s, false);    // DESC
        checkStack(s, false);
    }
}
