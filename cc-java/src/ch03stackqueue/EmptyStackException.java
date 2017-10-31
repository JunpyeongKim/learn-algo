package ch03stackqueue;

public class EmptyStackException extends Exception {
    public EmptyStackException(int stackNum) {
        super("Stack#" + stackNum);
    }
}