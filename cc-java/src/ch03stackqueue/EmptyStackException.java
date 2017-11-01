package ch03stackqueue;

public class EmptyStackException extends Exception {
    public EmptyStackException() {
    }

    public EmptyStackException(int stackNum) {
        super("Stack#" + stackNum);
    }
}