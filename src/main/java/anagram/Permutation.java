package anagram;

import java.util.Arrays;

public class Permutation {

    //This approach reduces the use of memory
    public static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }

    //This approach is more human-readable code
    static boolean permutationWithSortAlgorithm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    static String sort(String s) {
        final var content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);

    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutationWithSortAlgorithm(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
