package substrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 *<p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * <p>
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> foundCharacters = new HashSet<>();
        int substringSize = 0;
        List<Integer> substringsCount = new ArrayList<>();

        char[] characters = s.toCharArray();
        int count = 0;

        if (characters.length == 1) {
            return 1;
        }

        while (count < characters.length) {
            for (int i = count; i < characters.length; i++) {
                char c = characters[i];
                if (foundCharacters.contains(c)) {
                    if (substringSize != 0) {
                        substringsCount.add(substringSize);
                    }

                    foundCharacters = new HashSet<>();
                    substringSize = 0;
                    break;
                }
                foundCharacters.add(c);
                substringSize++;
            }
            count++;
        }
        return substringsCount.stream().max(Integer::compareTo).orElse(0);
    }

}
