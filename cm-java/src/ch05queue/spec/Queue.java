package ch05queue.spec;

import lib.UnderflowException;

interface Queue {
    // The following operations make a queue an ADT.

    // Main operations
    void enqueue(int data); // OverflowException
    int dequeue() throws UnderflowException;  // UnderflowException

    // Auxiliary operations
    // int front();
    // int rear();
    int size();
    boolean isEmpty();
    boolean isFull();
//    void clear();
}
