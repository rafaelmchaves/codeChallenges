package twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

	//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	//You may assume that each input would have exactly one solution, and you may not use the same element twice.
	//You can return the answer in any order.

	//Example 1:
	//
	//Input: nums = [2,7,11,15], target = 9
	//Output: [0,1]
	//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	//
	//Example 2:
	//
	//Input: nums = [3,2,4], target = 6
	//Output: [1,2]
	//
	//Example 3:
	//
	//Input: nums = [3,3], target = 6
	//Output: [0,1]

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
		System.out.println(Arrays.toString(twoSum(new int[]{3,2,5,4}, 6)));
		System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
		System.out.println(Arrays.toString(twoSum(new int[]{3,4}, 6)));

	}

	private static int[] twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i= 0; i < array.length; i++) {
			var result = target - array[i];
			if (map.containsKey(result)) {
				return new int[] {map.get(result), i};
			} else {
				map.put(array[i], i);
			}
		}

		return new int[0];

	}

}
