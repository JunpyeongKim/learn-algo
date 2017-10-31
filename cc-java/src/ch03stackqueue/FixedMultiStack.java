package ch03stackqueue;

public class FixedMultiStack extends AbstractMultiStack {
    private int[] values;
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] sizes;

    // Constructor
    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[numberOfStacks * stackCapacity];
        sizes = new int [numberOfStacks];
    }

    // Private API
    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        return offset + sizes[stackNum] - 1;
    }

    // Public API
    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException(stackNum, value);
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException(stackNum);
        }

        int index = indexOfTop(stackNum);
        int value = values[index];
        values[index] = 0;
        sizes[stackNum]--;
        
        return value;
    }

    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException(stackNum);
        }

        return values[indexOfTop(stackNum)];
    }

    public int[] getValues() {
        return values;
    }

    public int[] getStackValues(int stackNum) {
        int[] stackValues = new int[sizes[stackNum]];
        int offset = stackNum * stackCapacity;

        for (int i = 0; i < sizes[stackNum]; i++) {
            stackValues[i] = values[offset + i];
        }

        return stackValues;
    }

    public String stackToStrin(int stackNum) {
        int[] items = getStackValues(stackNum);
        return items.toString();
    }
}