package ch19dp.spec;

public class FibonacciSeriesTest {
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries(8181);
        int result = fibonacciSeries.furtherImprovingFibonacci(8181);
        System.out.println(result);
    }
}