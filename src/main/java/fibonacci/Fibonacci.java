package fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    //O(2ˆn)
    private static long fibonacciRecursive(int number) {

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

    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(8));
        System.out.println(fibonacciRecursive(43));
        System.out.println(fibonacciIterative(8));
        System.out.println(fibonacciIterative(2));
        System.out.println(fibonacciIterative(1));
        System.out.println(fibonacciIterative(1000));
    }
}
