package ch04stack.spec;

import ch03linkedlist.spec.SLLNode;
import lib.UnderflowException;

/*
 Linked List Implementation
 */
public class LinkedListStack implements Stack {
    private SLLNode top;
    private int length;

    public LinkedListStack() {
    }

    //--------------------------------------------------------------------------------
    // Main operations
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    // Space Complexity: O(n)
    @Override
    public void push(int data) {
        SLLNode sllNode = new SLLNode(data);
        sllNode.setNext(top);
        top = sllNode;

        length++;
    }

    // Time Complexity: O(1)
    @Override
    public int pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        } else {
            int data = top.getData();
            top = top.getNext();
            length--;

            return data;
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

        return top.getData();
    }

    // Time Complexity: O(1) or O(n)
    @Override
    public int size() {
        // Alternative 01
//        SLLNode current = top;
//        int length = 0;
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
        if (top == null)    // (length == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n) //TODO:
    public void clear() {
        // if necessary, required to release each node
        top = null;
        length = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        SLLNode current = top;
        while (current != null) {
            sb.append(current.getData() + "\n");
            current = current.getNext();
        }

        return sb.toString();
    }
}