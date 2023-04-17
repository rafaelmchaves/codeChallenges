package codility;

public class Solution {
	public int solution(String S) {
		int count = 0;
		for (int i =0; i < S.length(); i ++) {
			if(S.substring(0, i).equals(S.substring( S.length() - i - 1, S.length() - 1))) {
				count = i + 1;
			}
		}
		// write your code in Java SE 8
		return count;
	}
}
