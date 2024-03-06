package array;

public class MissingNumber {

    //O(n) time complexity
    //O(n) space complexity
    public static int find(int[] array, int n) {

        if (array.length == n) {
            return 0;
        }

        boolean[] tempArray = new boolean[n];

        for (int i = 0; i <= n - 2; i++) {
            tempArray[array[i] - 1] = true;
        }

        for (int i = 0; i < tempArray.length; i++) {
            if (!tempArray[i]) {
                return i + 1;
            }
        }

        return 0;
    }

    public static int findWithoutTempArray(int[] array, int n) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        int completedNSum = 0;
        for (int i = 1; i <= n; i++) {
            completedNSum = completedNSum + i;
        }

        return completedNSum - sum;
    }

}

