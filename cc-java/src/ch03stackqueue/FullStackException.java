package ch03stackqueue;

public class FullStackException extends Exception {

    public FullStackException(int stackNum, int value) {
        super("Stack#" + stackNum + " : " + value);
    }
}