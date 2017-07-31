package ch03linkedlist.spec;

/*
 Circular Linked List
*/
public class CLLNode {
    private int data;
    private CLLNode next;
//    private CLLNode previous;
    private int length;

    public CLLNode(int data) {
        this.data = data;
    }

    public CLLNode() {
        this(Integer.MIN_VALUE);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

//    public CLLNode getPrevious() {
//        return previous;
//    }
//
//    public void setPrevious(CLLNode previous) {
//        this.previous = previous;
//    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
