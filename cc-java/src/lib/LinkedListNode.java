package lib;


public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public LinkedListNode previous;
    public LinkedListNode last;

    public LinkedListNode(int data, LinkedListNode next, LinkedListNode previous) {
        this.data = data;
        setNext(next);
        setPrevious(previous);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;

        if (next != null && next.getPrevious() != this) {
            next.setPrevious(this);
        }
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;

        if (previous != null && previous.getNext() != this) {
            previous.setNext(this);
        }
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------
    public String printForward() {
        StringBuffer sb = new StringBuffer();

        sb.append(data + " -> ");

        if (next != null) {
            sb.append(next.printForward());
        } else {
            sb.append("NULL");
        }

        return sb.toString();
    }

    public LinkedListNode clone() {
        LinkedListNode nextNode = null;

        if (next != null) {
            nextNode = next.clone();
        }

        LinkedListNode node = new LinkedListNode(data, nextNode, null);
        return node;
    }
}
