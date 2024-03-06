package array;

/**
 * Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {

    public static int countTrappedWater(int[] array) {

        int trapWater = 0;
        int leftNumber = array[0];
        boolean rightBorder = false;
        int sum = 0;
        int positions = 0;

        for (int i = 1; i < array.length; i++) {

            int number = array[i];

            if (number >= leftNumber) {
               rightBorder = true;
            } else {
               sum += number;
               positions += 1;
            }

            if (rightBorder) {
                trapWater += (positions * leftNumber) - sum;
                rightBorder = false;
                leftNumber = number;
                positions = 0;
                sum = 0;
            }

        }

        return trapWater;
    }

}
