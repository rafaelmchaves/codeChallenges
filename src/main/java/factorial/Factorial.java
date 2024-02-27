package factorial;

public class Factorial {

    //O(n)
    private static long factorial(int number) {

        if (number == 2) {
            return 2;
        }

        return number * factorial (number - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
