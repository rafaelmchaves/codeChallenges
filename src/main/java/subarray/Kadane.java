package subarray;

/**
* Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within an array[] with the largest sum.
 */
class Kadane {
    // Driver Code
    public static void main(String[] args)
    {
        int[] a = { -2, -6, 4, -1, -2, -3, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(a));
    }

    // Function Call
    static int maxSubArraySum(int[] array) {
        int max = 0;
        int max_temp_array = 0;

        for (int i = 0; i < array.length; i++) {
            max_temp_array = max_temp_array + array[i];
            if (max_temp_array < 0) {
                max_temp_array = 0;
            }

            if (max < max_temp_array) {
                max = max_temp_array;
            }

        }

        return max;
    }
}