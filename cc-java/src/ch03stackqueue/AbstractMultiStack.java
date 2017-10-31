package ch03stackqueue;

import lib.AssortedMethods;

public abstract class AbstractMultiStack {
    public abstract int[] getValues();

    public void print() {
        System.out.println(AssortedMethods.arrayToString(getValues()));
    }
}