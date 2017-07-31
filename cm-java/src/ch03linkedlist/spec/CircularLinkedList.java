package ch03linkedlist.spec;

import lib.UnderflowException;

/*
 Circular Linked List
*/
public class CircularLinkedList {
    private CLLNode head;

    public CircularLinkedList() {

    }


    //--------------------------------------------------------------------------------
    // Traversing
    //--------------------------------------------------------------------------------

    // Time Complexity: O(1)
    public synchronized CLLNode getHead() {
        return head;
    }

    // Time Complexity: O(n)
    public synchronized CLLNode getLast() {
        CLLNode current = head;

        while (current.getNext() != head) {
            current = current.getNext();
        }

        return current;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int getLength() {
        int length = 0;
        CLLNode current = head;

        while (current != null) {
            length++;

            current = current.getNext();
            if (current == head) {
                break;
            }
        }

        return length;
    }


    //--------------------------------------------------------------------------------
    // Inserting a node
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void insertAtEnd(int data) {
        CLLNode current = head;
        CLLNode cllNode = new CLLNode(data);

        if (head == null) {
            head = cllNode;
            cllNode.setNext(cllNode);
            return;
        }

        while (current.getNext() != head) {
            current = current.getNext();
        }

        current.setNext(cllNode);
        cllNode.setNext(head);
    }


    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void insertAtBegin(int data) {
        CLLNode current = head;
        CLLNode cllNode = new CLLNode(data);

        if (head == null) {
            head = cllNode;
            cllNode.setNext(cllNode);
            return;
        }

        while (current.getNext() != head) {
            current = current.getNext();
        }

        current.setNext(cllNode);
        cllNode.setNext(head);
    }

    public void insertAtMiddle(int data, int position) {
        // TODO:
    }


    //--------------------------------------------------------------------------------
    // Deleting a node
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void deleteAtEnd() throws UnderflowException {
        CLLNode previous = head, current = head;

        if (head == null) {
            throw new UnderflowException();
        }

        while (current.getNext() != head) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(head);
        current = null;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void deleteAtBegin() throws UnderflowException {
        CLLNode temp = head, current = head;

        if (head == null) {
            throw new UnderflowException();
        }

        while (current.getNext() != head) {
            current = current.getNext();
        }

        current.setNext(head.getNext());
        head = head.getNext();
        temp = null;
    }

    public void deleteAtMiddle(int position) {
        // TODO:
    }

    public void deleteAtMiddleMatched(int data) {
        // TODO:
    }


    //--------------------------------------------------------------------------------
    // Deleting Circular Linked List
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void clear() {
//        head = null;    // inefficient

        CLLNode temp = head, current = head;

        while (current.getNext() != head) {
            head.setNext(current.getNext());
            current = head.getNext();
        }

        current.setNext(null);
        head.setNext(null);
        head = null;
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        CLLNode current = head;

        while (current != null) {
            sb.append(current.getData() + "->");
            current = current.getNext();

            if (current == head) {
                break;
            }
        }
        sb.append("(" + current.getData() + ")head");

        return sb.toString();
    }
}