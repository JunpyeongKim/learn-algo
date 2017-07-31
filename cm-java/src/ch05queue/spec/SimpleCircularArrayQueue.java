package ch05queue.spec;

import lib.OverflowException;
import lib.UnderflowException;

/*
 Simple Circular Array Implementation
 */
public class SimpleCircularArrayQueue implements Queue {
    private static final int CAPACITY = 16;

    private int front;
    private int rear;
    private int capacity;
    private int[] array;
    private int length;

    public SimpleCircularArrayQueue(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        this.array = new int[this.capacity];
        this.length = 0;
    }

    public SimpleCircularArrayQueue() {
        this(CAPACITY);
    }


    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    // Space Complexity: O(n)
    @Override
    public void enqueue(int data) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        } else {
            length++;

            rear = (rear + 1) % capacity;
            array[rear] = data;

            if (front == -1)
                front = rear;
        }
    }

    // Time Complexity: O(1)
    @Override
    public int dequeue() throws UnderflowException {
        int data;

        if (isEmpty()) {
            throw new UnderflowException();
        } else {
            length--;

            data = array[front];

            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
        }

        return data;
    }


    //--------------------------------------------------------------------------------
    // Auxiliary operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    public int front() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return array[front];
    }

    // Time Complexity: O(1)
    public int rear() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return array[rear];
    }

    // Time Complexity: O(1)
    @Override
    public int size() {
        // Alternative 01
//        if (isEmpty())
//            return 0;
//
//        int length = ((rear - front + 1 + capacity) % capacity);
//        if (length == 0)
//            return capacity;
//        else
//            return length;

        // Alternative 02
        return length;
    }

    // Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return (front < 0); // (length == 0);
    }

    // Time Complexity: O(1)
    @Override
    public boolean isFull() {
        return (((rear + 1) % capacity) == front);  // (length == capacity);
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Deleting Simple Circular Array Queue
    // Time Complexity: O(1)
    public void clear() {
        front = rear = -1;
        length = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int length = size();

        sb.append("[");

        for (int i = 0; i < length; i++) {
            sb.append(array[(front + i) % capacity]);

            if (i < length - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}