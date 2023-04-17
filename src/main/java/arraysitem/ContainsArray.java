package arraysitem;

import java.util.HashSet;

public class ContainsArray {

	// Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
	//For Example:
	//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'i'];
	//should return false.
	//-----------
	//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'x'];
	//should return true.

	// 2 parameters - arrays - no size limit
	// return true or false

	public static void main(String[] args) {

		var array1 = new char[] {'a', 'b', 'c', 'x'};
	 	var array2 = new char[] {'z', 'y', 'd'};
		 System.out.println(containsCommonItem(array1, array2));
	}

	private static boolean containsCommonItem(char[] array1, char[] array2) {

		HashSet<Character> hashSet = new HashSet<>();

		for (char charArray: array1) {
			hashSet.add(charArray);
		}

		for (char element: array2) {
			if (hashSet.contains(element)) {
				return true;
			}
		}

		return false;
	}

}
