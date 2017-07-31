package ch03linkedlist.spec;

/*
 Doubly Linked List
 */
public class DoublyLinkedList {
    private DLLNode head;
//    private DLLNode tail;
    private int length;

    public DoublyLinkedList() {

    }


    //--------------------------------------------------------------------------------
    // Traverse
    //--------------------------------------------------------------------------------

    public synchronized DLLNode getHead() {
        return head;
    }

    // Time Complexity: O(n)
    public synchronized DLLNode getLast() {
        if (head == null || head.getNext() == null)
            return head;

        DLLNode current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current;
    }

    // Time Complexity: O(n) or O(1)
    // Space Complexity: O(1)
    public int getLength() {
        // Alternative 01
//        int length = 0;
//        DLLNode current = head;
//
//        while (current != null) {
//            length++;
//            current = current.getNext();
//        }

        // Alternative 02
        return length;
    }

    // Time Complexity: O(n)
    public int getPosition(int data) {
        DLLNode current = head;
        int position = 1;

        while(current != null) {
            if (current.getData() == data)
                return position;

            current = current.getNext();
            position++;
        }

        return Integer.MIN_VALUE;   // -2^31
    }

    // Time Complexity: O(n)
    public int getData(int position) {
        DLLNode current = head;
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

    // Time Complexity: O(n) in the worst case
    // Space Complexity: O(1) for temporary variable
    public DLLNode insert(int data, int position) {
        if (head == null) {
            length++;
            head = new DLLNode(data);
            return head;
        }

        int size = getLength();
        if (position < 1 || position > size + 1) {
            System.out.println("Position of nodeToInsert is invalid. The valid inputs are 1 to " + (size + 1));
            return head;
        }

        length++;

        if (position == 1) {
            // Beginning
            DLLNode dllNode = new DLLNode(data);
            dllNode.setNext(head);
            head.setPrevious(dllNode);
            head = dllNode;
            return head;
        } else {
            // Middle | End
            DLLNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.getNext();
                count++;
            }

            DLLNode current = previous.getNext();
            DLLNode dllNode = new DLLNode(data);

            dllNode.setNext(current);
            if (current != null) {
                current.setPrevious(dllNode);
            }

            previous.setNext(dllNode);
            dllNode.setPrevious(previous);
        }

        return head;
    }


    //--------------------------------------------------------------------------------
    // Deleting a Node
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1) for temporary variable
    public DLLNode delete(int position) {
        if (head == null)
            return head;

        int size = getLength();
        if (position < 1 || position > size) {
            System.out.println("Position of nodeToInsert is invalid. The valid inputs are 1 to " + size);
            return head;
        }

        length--;

        if (position == 1) {
            // Beginning
            DLLNode current = head.getNext();
            current.setPrevious(null);
            head.setNext(null);
            head = current;
            return head;
        } else {
            // Middle | End
            DLLNode previous = head;
            int count = 1;

            while (count < position - 1) {
                previous = previous.getNext();
                count++;
            }

            DLLNode current = previous.getNext();
            DLLNode next = current.getNext();

            previous.setNext(next);

            if (next != null) {
                next.setPrevious(previous);
            }

            current.setPrevious(null);
            current.setNext(null);
            current = null;
        }

        return head;
    }

    public void deleteMatched(int data) {
        // TODO:
    }


    //--------------------------------------------------------------------------------
    // Deleting Doubly Linked List
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void clear() {
        // Alternative 01
//        head = null;    // inefficient

        // Alternative 02
        DLLNode current = head, next;
        while (current != null) {
            next = current.getNext();

            next.setPrevious(null);
            current.setNext(null);
            current = next;
        }
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------

    // Time Complexity: O(n)
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        DLLNode current = head;

        while (current != null) {
            sb.append(current.getData() + "<->");
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