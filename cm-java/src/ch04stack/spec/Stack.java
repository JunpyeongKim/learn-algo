package ch04stack.spec;

interface Stack {
    // The following operations make a stack an ADT.

    // Main operations
    void push(int data);
    int pop();

    // Auxiliary operations
    int top();
    int size();
    boolean isEmpty();
    boolean isFull();
//    void clear();
}