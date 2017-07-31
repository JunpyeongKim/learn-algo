package ch19dp.spec;

/*
Fibonacci Series
the current number is the sum of previous two numbers.
 */
public class FibonacciSeries {
    private int nth;

    public FibonacciSeries(int nth) {
        this.nth = nth;
    }

    // recursive implementation
    // TODO: Complexity ???
    public int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

    // memoization: bottom-up
    // Time, Space O(n)
    int[] fibBottomUpTable = new int[this.nth];

    public int memoizationBottomUpFibonacci(int n) {
        if (n == 0 || n == 1) return 1; // TODO: why 1 when n == 0 ???

        fibBottomUpTable[0] = 1;
        fibBottomUpTable[1] = 1;
        for (int i = 2; i < n; i++) {
            fibBottomUpTable[i] = fibBottomUpTable[i-1] + fibBottomUpTable[i-2];
        }

        return fibBottomUpTable[n-1];
    }

    // memoization: top-down
    // Time, Space O(n)
    int[] fibTopDownTable = new int[nth];
    public int memozationTopDownFibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;

        if (fibTopDownTable[n] != 0) return fibTopDownTable[n];

        return fibTopDownTable[n] = memozationTopDownFibonacci(n-1) + memozationTopDownFibonacci(n-2);
    }

    // Further improving
    // Time O(n)
    // Space O(1)
    public int furtherImprovingFibonacci(int n) {
        int a = 0, b = 1, sum = 0, i;
        for(i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // n = 8181: 241864431
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        FibonacciSeries fibonacciSeries = new FibonacciSeries(n);
        int result = fibonacciSeries.furtherImprovingFibonacci(n);
        System.out.println(result);
    }
}