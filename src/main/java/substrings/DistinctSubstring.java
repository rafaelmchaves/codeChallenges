package substrings;

import java.util.HashSet;

/**
 * Given a string, count all distinct substrings of the given string.
 * Examples:
 * Input : abcd
 * Output : abcd abc ab a bcd bc b cd c d
 * All Elements are Distinct
 *
 * Input : aaa
 * Output : aaa aa a aa a a
 * All elements are not Distinct
 */
public class DistinctSubstring {

    public static int distinctSubstring(String string) {

        if (string == null) {
            return 0;
        }
        final HashSet<String> distinctElements = new HashSet<>();

        //O(nˆ2)
        for (int i = 0; i <= string.length(); i++) {
            for(int j = i + 1; j <= string.length(); j++) {
                distinctElements.add(string.substring(i, j));
            }
        }

        distinctElements.forEach(element -> System.out.print(element + " "));
        return distinctElements.size();
    }

    public static void main(String[] args) {
        System.out.println(distinctSubstring("abcd"));
        System.out.println(distinctSubstring("aaaa"));

    }
}
