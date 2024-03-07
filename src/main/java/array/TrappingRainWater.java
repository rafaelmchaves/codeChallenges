package array;

/**
 * Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * https://www.geeksforgeeks.org/trapping-rain-water/
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

}
