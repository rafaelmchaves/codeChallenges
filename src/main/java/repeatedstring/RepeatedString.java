package repeatedstring;

public class RepeatedString {

    private static final char LETTER_A = 'a';

    public static long getQuantityOfa(String string, long n) {

        if (string == null) {
            return 0;
        }
        final var size = string.length();

        if (size == 0) {
            return 0;
        }

        final var repeated = n/size;

        final var count = getCountaInTheString(string);

        final var extra = getExtraLettera(n, string, repeated, size);

        return  (repeated * count) + extra;
    }

    private static int getCountaInTheString(String string) {

        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == LETTER_A) {
                count++;
            }
        }
        return count;
    }

    private static Integer getExtraLettera(long n, String string, long repeated, Integer size) {
        int extra = 0;
        final long left = n - (repeated * size);
        for(int i = 0; i < left; i++){
            if(string.charAt(i) == LETTER_A){
                extra++;
            }
        }

        return extra;
    }



}
