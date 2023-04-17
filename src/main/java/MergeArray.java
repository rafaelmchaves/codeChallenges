import java.util.Arrays;

public class MergeArray {


	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSortedArrays(new int[]{-1, 0, 3, 4, 31, 45}, new int[]{4, 6, 30})));
		System.out.println(Arrays.toString(mergeSortedArrays(new int[]{-1, 0, 3, 4}, new int[]{4, 6, 30, 31, 45, 50})));
		System.out.println(Arrays.toString(mergeSortedArrays(new int[]{}, new int[]{4, 6, 30, 31, 45, 50})));
		System.out.println(Arrays.toString(mergeSortedArrays(new int[]{4, 6, 30, 31, 45, 50}, new int[]{})));
	}

	private static int[] mergeSortedArrays(int[] array1, int[] array2) {

		var pivot1 = 0;
		var pivot2 = 0;

		if (array1.length == 0) {
			return array2;
		}
		if (array2.length == 0) {
			return array1;
		}

		final int[] mergedArray = new int[array1.length + array2.length];
		int positionMergedArray = 0;

		while (pivot1 < array1.length && pivot2 < array2.length) {
			if(array1[pivot1] < array2[pivot2]) {
				mergedArray[positionMergedArray] = array1[pivot1] ;
				pivot1++;
			} else {
				mergedArray[positionMergedArray] = array2[pivot2];
				pivot2++;
			}

			positionMergedArray ++;
		}

		if (pivot1 < array1.length) {

			for (int i = pivot1; i < array1.length; i++) {
				mergedArray[positionMergedArray] = array1[i];
				positionMergedArray ++;
			}
		} else if(pivot2 < array2.length) {
			for (int i = pivot2; i < array2.length; i++) {

				mergedArray[positionMergedArray] = array2[i];
				positionMergedArray ++;
			}
		}

		return mergedArray;
	}
//	mergeSortedArrays([0,3,4,31], [4,6,30]);
//	convert to [0,3,4,4,6,30,31]

	// pivot1 < 4
	// pivot2 < 3
	//31 < 30
	//pivot1 = 3
	//pivot2 = 3
	//[0, 3, 4, 4, 6, 30]


	// create a pivot in each array starting from the first position

	// array1 : [0,3,4,31]; pivot1 = 0
	// array2 : [4,6,30]; pivot2 = 0

	//for each element in the array1, ask if array1[pivot1] < array2[pivot2].
	//If yes, add array1[pivot1] in the new array
	//  pivot1++

	//if not, add array2[pivot2] in the new array
	// pivot2++

	//return new array

	//	O(array1 + array2)


}
