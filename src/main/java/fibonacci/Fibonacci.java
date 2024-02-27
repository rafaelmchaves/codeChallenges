package fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    private static int calculations = 0;
    //O(2ˆn)
    private static long fibonacciRecursive(int number) {

        calculations++;
        if (number < 2) {
            return number;
        }

        return fibonacciRecursive(number - 1) + fibonacciRecursive(number -2);
    }

    //O(n)
    private static long fibonacciIterative(int number) {

        List<Long> list = new ArrayList<>(Arrays.asList(0L, 1L));
        for (int i = 2; i <= number; i++) {
            list.add(list.get(i - 1) + list.get(i -2));
        }

        return list.get(number);
    }

    //O(n)
    private static long fibonacciRecursiveMemo(int number, long[] memo) {

        calculations++;
        if (number < 2) {
            return number;
        }

        if (memo[number] == 0) {
            memo[number] = fibonacciRecursiveMemo(number - 1, memo) + fibonacciRecursiveMemo(number -2, memo);
        }

        return memo[number];
    }

    public static void main(String[] args) {

        System.out.println(fibonacciRecursive(43));
        System.out.println("fibonacciRecursive did " + calculations + " calculations");
        calculations = 0;
        System.out.println(fibonacciRecursiveMemo(43, new long[44]));
        System.out.println("fibonacciRecursiveMemo did " + calculations + " calculations");

    }
}
