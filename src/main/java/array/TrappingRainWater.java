package array;

/**
 * Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <a href="https://www.geeksforgeeks.org/trapping-rain-water/">https://www.geeksforgeeks.org/trapping-rain-water/</a>
 */
public class TrappingRainWater {

    //time complexity O(nˆ2)
    public static int countTrappedWater(int[] array) {

        int result = 0;
        int left;
        int right;

        int size = array.length;

        for (int i = 1; i < size - 1; i++) {

            left = array[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(array[j], left);
            }

            right = array[i];
            for (int j = i + 1; j < size; j++) {
                right = Math.max(array[j], right);
            }

            result += Math.min(left, right) - array[i];

        }

        return result;
    }

    //O(Max(height, array_size))
    public static int count(int[] arr) {
        // To store the number of blocks
        int n = arr.length;

        // To store the sum of all the heights
        int num_blocks = 0;

        // To store the maximum height in the array
        int max_height = Integer.MIN_VALUE;

        // Compute the sum of all heights and the
        // maximum height given in the array
        for (int i = 0; i < n; i++) {
            max_height = Math.max(max_height, arr[i]);
            num_blocks += arr[i];
        }

        // To store the answer and initialise
        // the left and right pointers
        int total = 0, left = 0, right = n - 1;

        for (int i = 1; i <= max_height; i++) {

            // Compute the leftmost point greater than
            // current row (i)
            while (arr[left] < i) {
                left++;
            }

            // Compute the rightmost point greater than
            // current row (i)
            while (arr[right] < i) {
                right--;
            }

            // Water in this row = right - left + 1(add 1 because we are increasing the height in 1 unit)
            total += (right - left + 1);
        }

        total -= num_blocks;
        return total;
    }

}
