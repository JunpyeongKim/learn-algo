package ch03stackqueue;

import lib.AssortedMethods;

import java.util.Stack;

/**
 * 3.6 큰 값이 위에 오도록 스택을 오름차순 정렬하는 프로그램을 작성하라.
 *     여벌 스택은 하나까지만 사용할 수 있고, 스택에 보관된 요소를 배열 등의 다른 자료구조로는 복사할 수 없다.
 *     스택은 push, pop, peek, isEmpty 의 네 가지 연산을 제공한다.
 *
 * (4E)
 * 3.6 Write a program to sort a stack in ORDER_BY.ASCending order.
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
public class StackQueue06 {
    private enum ORDER_BY {
        ASC,    // The biggest items are on the top.
        DESC    // The smallest items are on the top.
    }

    //--------------------------------------------------------------------------------
    // Solution #1: Using another stack
    //              --> 여러 번의 push/pop 필요
    //--------------------------------------------------------------------------------
    public static void sort(Stack<Integer> s, ORDER_BY orderBy) {
        Stack<Integer> t = new Stack<Integer>();
        // StringBuffer sb = new StringBuffer();

        // Sort
        while (!s.isEmpty()) {
            int data = s.pop();

            if (ORDER_BY.ASC.equals(orderBy)) {
                // for the biggest items in order to be at the bottom. 
                // --> opposite order, in other words, Descending order
                while (!t.isEmpty() && t.peek() < data) {
                    s.push(t.pop());
                }
            } else {
                // sort in ORDER_BY.ASCending order <-- for the smallest items in order to be at the bottome.
                while (!t.isEmpty() && t.peek() > data) {
                    s.push(t.pop());
                }
            }

            t.push(data);
        }

        // Reverse
        while (!t.isEmpty()) {
            int value = t.pop();
            s.push(value);
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #2: Using the Merge sort
    //              --> 2^n 개의 Element 가 존재하면 --> 최소 n개의 callstack 필요
    //              --> 이 경우, 추가 스택은 2^1 + 2^2 + ... 2^n 개 --> 거의 n^2 개 스택 필요
    //--------------------------------------------------------------------------------
    public static Stack<Integer> mergeSort(Stack<Integer> inStack, ORDER_BY orderBy) {
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
        left = mergeSort(left, orderBy);
        right = mergeSort(right, orderBy);
        
        int data;

        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.size() == 0) {
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                data = ORDER_BY.ASC.equals(orderBy) ? left.pop() : right.pop();
                inStack.push(data);
            } else {
                data = ORDER_BY.ASC.equals(orderBy) ? right.pop() : left.pop();
                inStack.push(data);
            }
        }

        //TODO: Reverse 를 하지 않을 방법은 ???
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
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            int data = AssortedMethods.randomIntInRange(0, 100);    // (int)((Math.random() * 1000) % 1000);
            s.push(data);

            // logging
            sb.append(data);
            sb.append("\n");
        }

        System.out.println("\nNew stack:\n" + sb.toString());
        return s;
    }

    private static void checkStack(Stack<Integer> s, ORDER_BY orderBy) {
        StringBuffer sb = new StringBuffer();
        int last = ORDER_BY.ASC.equals(orderBy) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        String order = ORDER_BY.ASC.equals(orderBy) ? "ORDER_BY.ASC" : "ORDER_BY.DESC";
        System.out.println("---> " + order + ": \n");

        while (!s.isEmpty()) {
            int curr = s.pop();
            sb.append(curr);
            sb.append("\n");

            boolean error = ORDER_BY.ASC.equals(orderBy) ? curr > last : curr < last;
            if (error) {
                System.out.println("Error: " + last + " " + curr);
            }

            last = curr;
        }

        System.out.println("(Top) \n" + sb.toString() + "(Bottom)");
    }

    public static void main(String[] args) {
        Stack<Integer> s;

        // 
        s = makeStack();
        sort(s, ORDER_BY.ASC);
        checkStack(s, ORDER_BY.ASC);

        s = makeStack();
        sort(s, ORDER_BY.DESC);
        checkStack(s, ORDER_BY.DESC);

        //
        s = makeStack();
        s = mergeSort(s, ORDER_BY.ASC);
        checkStack(s, ORDER_BY.ASC);

        s = makeStack();
        s = mergeSort(s, ORDER_BY.DESC);
        checkStack(s, ORDER_BY.DESC);
    }
}
