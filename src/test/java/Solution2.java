import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2 {

	public int solution(String s) {
		int length = s.length();
		int[] arrayCount = new int[length];
		int j = 0;
		for (int i = 1; i < length; ) {
			if (s.charAt(i) == s.charAt(j)) {
				arrayCount[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0) {
					j = arrayCount[j - 1];
				} else {
					i++;
				}
			}
		}

		return arrayCount[arrayCount.length-1];
	}

	public static int getLength(String S) {
		int n = S.length();

		int lps[] = new int[n];

		lps[0] = 0;

		int len = 0;

		int i = 1;

		while (i<n) {
			if (S.charAt(i) == S.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len !=0 ) {
					len = lps[len-1];
				} else {
					lps[i] = 0;
					i++;
				}
			}

		}
		int res = lps[n-1];

		return (res > n/2)? n/2: res;
	}


	@Test
	public void test() {
		Assertions.assertEquals(4, solution("abbabba"));
	}

	@Test
	public void testCodility() {
		Assertions.assertEquals(0, solution("codility"));
	}

	@Test
	public void test1Million() {
		StringBuilder x = new StringBuilder();
		x.append("a".repeat(1000000));
		Assertions.assertEquals(999999, solution(x.toString()));
	}
}
