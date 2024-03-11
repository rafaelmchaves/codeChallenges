package substrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    O(nˆ2)
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> foundCharacters = new HashSet<>();
        int substringSize = 0;
        List<Integer> substringsCount = new ArrayList<>();

        char[] characters = s.toCharArray();
        int count = 0;

        if (characters.length == 1) {
            return 1;
        }

        int maxLength = 0;

        while (count < characters.length) {
            for (int i = count; i < characters.length; i++) {
                char c = characters[i];
                if (foundCharacters.contains(c)) {
                    if (substringSize != 0) {
                        maxLength = Math.max(maxLength, substringSize);
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

        return maxLength;
    }

    //O (n) It will vary if the string has big substrings with a repeated element inside
    public static int getLength(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        getLength("abcabcbb");
        getLength("abcabdcbb");
        getLength("bbbbbbb");
    }

}
