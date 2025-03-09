package arraysitem;

import java.util.HashSet;
import java.util.Set;

public class ContainsArray2 {

	// Given 2 arrays, create a function that lets a user know (true/false) whether these two arrays contain any common items
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
	 	var array2 = new char[] {'z', 'y', 'x'};
	    System.out.println(containsCommonItem(array1, array2));
	}

	private static boolean containsCommonItem(char[] array1, char[] array2) {

		if (array1 == null || array2 == null) {
			return false;
		}

		//O(N)
		Set<Character> characterSet = new HashSet<>();
		for (int i = 0; i < array1.length; i++) {
			characterSet.add(array1[i]);
		}

		for (int i = 0; i < array2.length; i++) {
			if (characterSet.contains(array2[i])) {
				return true;
			}
		}

		return false;
	}

}
