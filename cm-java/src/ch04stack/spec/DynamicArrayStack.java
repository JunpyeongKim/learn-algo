package ch04stack.spec;

import lib.UnderflowException;

/*
 Dynamic Array Implementation
 */
public class DynamicArrayStack implements Stack {
    public static final int CAPACITY = 16;  // power of 2
    public static final int MINCAPACITY = 1 << 15;  // TODO: ???

    private int top;
    private int capacity;
    private int[] array;

    public DynamicArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.array = new int[this.capacity];    // TODO: compiler warning ???
    }

    public DynamicArrayStack() {
        this(CAPACITY);
    }

    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    // Space Complexity: O(n)
    @Override
    public void push(int data) {
        if (isFull()) {
            expand();
        }

        array[++top] = data;
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
        if (isEmpty()) {
            throw new UnderflowException();
        }

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

    private void expand() {
        int[] newArray = new int[capacity * 2]; // capacity << 1
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity * 2;    // capacity << 1
        array = newArray;
    }

    // TODO:
    @SuppressWarnings("unused")
    private void shrink() {
        int length = size();

        if (length <= MINCAPACITY || top << 2 >= length)    // TODO: ???
            return;

        length += top << 1;
        if (top < MINCAPACITY)
            length = MINCAPACITY;   // TODO: ???

        int[] newStack = new int[length];
        System.arraycopy(array, 0, newStack, 0, top + 1);
        array = newStack;
    }
}