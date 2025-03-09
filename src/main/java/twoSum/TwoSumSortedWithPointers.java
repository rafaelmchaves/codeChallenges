package twoSum;

import java.util.Arrays;

public class TwoSumSortedWithPointers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4,5}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,4,6,7,8}, 13)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,4}, 6)));

    }

    private static int[] twoSum(int[] array, int target) {
        int pointer1 = 0;
        int pointer2 = array.length - 1;

        while (pointer2 > pointer1) {
            int sum = array[pointer1] + array[pointer2];
            if (sum == target) {
                return new int[]{pointer1, pointer2};
            } else if (sum > target) {
                pointer2 -= 1;
            } else {
                pointer1 += 1;
            }
        }

        return new int[0];
    }
}
