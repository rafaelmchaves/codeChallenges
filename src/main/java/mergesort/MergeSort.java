package mergesort;

public class MergeSort {

    static void mergeSort(int[] array) {

        int size = array.length;
        if (size < 2) {
            return;
        }

        int mid = size/2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < size; i++) {
            right[i - mid] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }

    static void merge(int[] array, int[] left, int[] right) {

        int l = 0;
        int r = 0;
        int k = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                array[k] = left[l];
                l++;
            } else {
                array[k] = right[r];
                r++;
            }
            k++;
        }

        while (l < left.length) {
            array[k] = left[l];
            k++;
            l++;
        }
        while (r < right.length) {
            array[k] = right[r];
            k++;
            r++;
        }

    }

    public static void main(String[] args) {

        int[] array = new int[] { 5,2,8,12,4,3,7};
        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }

    }
}
