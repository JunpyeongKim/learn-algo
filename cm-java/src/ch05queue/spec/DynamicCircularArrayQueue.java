package ch05queue.spec;

import lib.UnderflowException;

/*
 Dynamic Circular Array Implementation
 */
public class DynamicCircularArrayQueue implements Queue {
    private static final int CAPACITY = 16;
    private static final int MINCAPACITY = 1 << 15; // TODO: ???

    private int front;
    private int rear;
    private int capacity;
    private int[] array;
    private int length;

    public DynamicCircularArrayQueue(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        this.array = new int[this.capacity];
        this.length = 0;
    }

    public DynamicCircularArrayQueue () {
        this(CAPACITY);
    }


    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1) (Average ???)  //TODO:
    // Space Complexity: O(n)
    public void enqueue(int data) {
        if (isFull()) {
            expand();
        }

        length++;

        rear = (rear + 1) % capacity;
        array[rear] = data;

        if (front == -1)
            front = rear;
    }

    // Time Complexity: O(1)
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
//        int length = (rear - front + 1 + capacity) % capacity;
//        if (length == 0) {
//            return capacity;
//        } else {
//            return length;
//        }

        // Alternative 02
        return length;
    }

    // Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return (front < 0);   // (length == 0);
    }

    // Time Complexity: O(1)
    @Override
    public boolean isFull() {
        return (((rear + 1) % capacity) == front);  // (length == capacity);
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Deleting Dynamic Circular Array Queue
    // Time Complexity: O(1)
    public void clear() {
        front = rear = -1;
        length = 0;
    }

    // Time Complexity: O(n)
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

    private void expand() {
        int initCapacity = capacity;
        capacity *= 2; // or capacity << 1;

        int[] oldArray = array;
        array = new int[capacity];

        // Alternative 01
//        for (int i = 0; i < oldArray.length; i++) {
//            array[i] = oldArray[i];
//        }

        // Alternative 02
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);

        if (rear < front) {
            for (int i = 0; i <= rear; i++) {   // or i < front
                array[i + initCapacity] = array[i];
//                array[i] = Integer.MIN_VALUE;    // TODO: necessary ???
            }

            rear = rear + initCapacity;
        }
    }

    @SuppressWarnings("unused")
    private void shrink() {
        // TODO: implement ???
    }
}