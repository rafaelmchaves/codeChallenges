package array;

public class MissingNumber {

    public static void main(String[] args) {
        
        int[] array = {1,2,4,6,3,7,8};
        System.out.println(find(array, 8));
        int[] array2 = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10};
        System.out.println(find(array2, 14));
        int[] array3 = {1,2,4,6,3,7,8,12, 14,9, 13,5, 10, 11};
        System.out.println(find(array3, 14));

    }

    //O(n) time complexity
    //O(n) space complexity
    private static int find(int[] array, int n) {

        if (array.length == n) {
            return -1;
        }

        boolean[] booleanArray = new boolean[n];

        for (int i = 0; i <= n - 2; i++) {
            booleanArray[array[i] - 1] = true;
        }

        for (int i = 0; i < booleanArray.length; i++) {
            if (!booleanArray[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
