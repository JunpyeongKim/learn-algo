package ch03linkedlist.spec;

/*
 Singly Linked List
 */
public class SinglyLinkedList {
    private SLLNode head;
    private int length;

    public SinglyLinkedList() {

    }

    //--------------------------------------------------------------------------------
    // Traversing
    //--------------------------------------------------------------------------------

    // TODO: synchronized
    public synchronized SLLNode getHead() {
        return head;
    }

    // TODO: synchronized
    // Time Complexity: O(n)
    public synchronized SLLNode getLast() {
        if (head == null || head.getNext() == null)
            return head;

        SLLNode current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current;
    }

    // Time Complexity: O(n) or O(1)
    // Space Complexity: O(1) for temporary variable
    public int getLength() {
        // Alternative 01
//        int length = 0;
//        SLLNode current = head;
//
//        while (current != null) {
//            length++;
//            current = current.getNext();
//        }

        // Alternative 02
        return length;
    }

    // Time Complexity: O(1)
    public int getPosition(int data) {
        SLLNode current = head;
        int position = 1;

        while (current != null) {
            if (current.getData() == data)
                return position;

            current = current.getNext();
            position++;
        }

        return Integer.MIN_VALUE;   // -2^31
    }

    // Time Complexity: O(n)
    public int getData(int position) {
        SLLNode current = head;
        int pos = 1;

        while (current != null) {
            if (pos == position)
                return current.getData();

            current = current.getNext();
            pos++;
        }

        return Integer.MIN_VALUE;   // -2^31
    }


    //--------------------------------------------------------------------------------
    // Inserting a node
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n). Since, in the worst at the end of the list.
    // Space Complexity: O(1) for one temporary variable.
    public SLLNode insert(int data, int position) {
        if (head == null) {
            length++;
            head = new SLLNode(data);
            return head;
        }

        int size = getLength();
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
            return head;
        }

        length++;

        if (position == 1) {
            // Beginning
            SLLNode sllNode = new SLLNode(data);
            sllNode.setNext(head);
            head = sllNode;
        } else {
            // Middle | End
            SLLNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.getNext();
                count++;
            }

            SLLNode current = previous.getNext();   // previous is called "position node"
            SLLNode sllNode = new SLLNode(data);
            sllNode.setNext(current);
            previous.setNext(sllNode);
        }

        return head;
    }


    //--------------------------------------------------------------------------------
    // Deleting a node
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n), in the worst, at then end
    // Space Complexity: O(1) for temporary variable.
    public SLLNode delete(int position) {
        if (head == null) {
            return head;
        }

        int size = getLength();
        if (position < 1 || position > size) {
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to " + size);
            return head;
        }

        length--;

        if (position == 1) {
            // Beginning
            SLLNode current = head.getNext();
            head = null;
            head = current;
        } else {
            // Middle | End
            SLLNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.getNext();
                count++;
            }

            SLLNode current = previous.getNext();
            previous.setNext(current.getNext());
            current = null;
        }

        return head;
    }

    public void deleteMatched(int data) {
        // TODO:
    }


    //--------------------------------------------------------------------------------
    // Deleting Singly Linked List
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void clear() {
        // Alternative 01 - inefficient
//        head = null;

        // Alternative 02
        SLLNode next, current = head;

        while (current != null) {
            next = current.getNext();
            current = null;    // taken care by garbage collector
            current = next;   // 실제로 중요하지 않은 구현 ???
        }

        length = 0;
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        SLLNode current = head;

        while (current != null) {
            sb.append(current.getData() + "->");
            current = current.getNext();

            if (current == null)
                sb.append("NULL");
        }

        return sb.toString();
    }

    public boolean isEmpty() {
        return (head == null);    // (length == 0);
    }
}