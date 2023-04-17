import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {
	public int solution(String S) {
		int count = 0;
		for (int i =0; i < S.length() - 1; i ++) {
			String prefix = S.substring(0, i + 1);
			String sufix = S.substring( S.length() - i - 1);
			if(prefix.equals(sufix) ) {
				count = i + 1;
				System.out.println(count);
			}
		}

		// write your code in Java SE 8
		return count;
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
