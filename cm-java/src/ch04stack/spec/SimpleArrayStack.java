package ch04stack.spec;

import lib.OverflowException;
import lib.UnderflowException;

/*
 Simple Array Implementation
 */
public class SimpleArrayStack implements Stack {
    private static final int CAPACITY = 16; // power of 2

    private int top;
    private int capacity;
    private int[] array;

    public SimpleArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.array = new int[this.capacity];    // TODO: compiler warning ???
    }

    public SimpleArrayStack() {
        this(CAPACITY);
    }

    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    // Space Complexity: O(n)
    @Override
    public void push(int data) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        } else {
            array[++top] = data;
        }
    }

    // Time Complexity: O(1)
    @Override
    public int pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        } else {
            return array[top--];
        }
    }

    //--------------------------------------------------------------------------------
    // Auxiliary operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    @Override
    public int top() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return array[top];
    }

    // Time Complexity: O(1)
    @Override
    public int size() {
        return (top + 1);   // array.length;
    }

    // Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return (top < 0);   // (array.length == 0);
    }

    // Time Complexity: O(1)
    @Override
    public boolean isFull() {
        return (top == capacity - 1);   // (top == array.length - 1);
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    public void clear() {
        top = -1;
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int len = size();

        sb.append("[");

        for (int i = 0; i < len; i++) {
            sb.append(array[i]);
            if (i < len -1)
                sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }
}
