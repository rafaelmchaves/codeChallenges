package reversestring;

public class ReverseStringMain {


	//This is my string
	//Convert to: gnirts ym si sihT
	public static void main(String[] args) {
		System.out.println(reverseString("This is my string"));
		System.out.println(reverseString("Rafael Chaves"));
		System.out.println(reverseString(null));
		System.out.println(recursiveReversal("Rafael Chaves"));
		System.out.println(recursiveReversal(null));
	}

	private static String reverseString(String string) {
		//O(n)
		//convert to char array
		//for each char in the array, starting from the last index until the first one
		//I will add this char in a stringBuilder class
		//return the string from the created stringBuilder

		if(string == null) {
			return null;
		}

		final char[] characterArray = string.toCharArray();
		final var stringBuilder = new StringBuilder();

		for (int i = characterArray.length - 1; i >= 0; i--) {
			stringBuilder.append(characterArray[i]);
		}

		return stringBuilder.toString();
	}

	public static String recursiveReversal (String str) {
		if (str == null) {
			return null;
		}

		if (str.length() == 0)  //breakpoint for recursion
			return "";

		return recursiveReversal(str.substring(1)) + str.charAt(0);
	}
}
