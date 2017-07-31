package ch05queue.spec;

import ch03linkedlist.spec.SLLNode;
import lib.UnderflowException;

/*
 Linked List Implementation
 */
public class LinkedListQueue implements Queue {
    private SLLNode front;   // head
    private SLLNode rear;    // last
    private int length;

    private LinkedListQueue() {
    }


    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1) (Average ???)  //TODO:
    // Space Complexity: O(n)
    @Override
    public void enqueue(int data) {
        SLLNode sllNode = new SLLNode(data);

        length++;

        if (rear != null) {
            rear.setNext(sllNode);
        }

        rear = sllNode;

        if (front == null) {
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

            data = front.getData();
            front = front.getNext();

            if (front == null)
                rear = null;
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

        return front.getData();
    }

    // Time Complexity: O(1)
    public int rear() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();

        return rear.getData();
    }

    // Time Complexity: O(1) or O(n)
    @Override
    public int size() {
        // Alternative 01
//        SLLNode current = front;
//        int length = 0;
//
//        while (current != null) {
//            length++;
//            current = current.getNext();
//        }

        // Alternative 02
        return length;
    }

    // Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return (front == null); // (length == 0);
    }

    @Override
    public boolean isFull() {
        return false;
    }


    //--------------------------------------------------------------------------------
    // Helper
    //-------------------------------------------------------------------------------

    // Time Complexity: O(1)
    public void clear() {
        front = rear = null;
        length = 0;
    }

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        SLLNode current = front;

        while (current != null) {
            sb.append(current.getData() + "->");
            current = current.getNext();
            if (current == null)
                sb.append("NULL");
        }

        return sb.toString();
    }
}