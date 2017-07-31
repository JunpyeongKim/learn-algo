package ch03linkedlist.spec;

/*
 Singly Linked List
  - Generally "linked list" means a singly linked list.
  - github/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/src/chapter03linkedlists/ListNode.java

    리스트의 기본 연산
    1. 리스트 탐색하기
    2. 리스트에 항목 삽입하기
    3. 리스트에서 항목 삭제하기

    리스트 탐색
    1. ...
*/
public class SLLNode {
    private int data;
    private SLLNode next;

    public SLLNode(int data) {
        this.data = data;
    }

    public SLLNode() {
        this(Integer.MIN_VALUE);
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(SLLNode next) {
        this.next = next;
    }

    public SLLNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
