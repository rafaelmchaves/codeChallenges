package binarysearch;

public class FirstAndLastOccurrenceOccurrence {

	public static void main(String[] args) {

		final var array = new int[]{-1, 1, 2, 2, 2, 5, 6, 12, 12};
//
//		final var result = getFindAndLastOccurrence(-1, array);
//
//		System.out.println("first occurrence: " + result[0]);
//		System.out.println("last occurrence: " + result[1]);

		System.out.println("target first position: " +  getFirstOccurrence(2, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(-1, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(12, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(6, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(5, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(8, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(15, array, 0, array.length - 1));
		System.out.println("target first position: " +  getFirstOccurrence(-2, array, 0, array.length - 1));
	}

	public static int[] getFindAndLastOccurrence (final int target, final int[] array) {

		if (array == null) {
			return new int[] {-1,-1};
		}

		final int firstOccurrence = getFirstOccurrence(target, array, 0, array.length - 1);
		final int lastOccurrence = getLastOccurrence(target, array, 0, array.length - 1);

		return new int[]{firstOccurrence, lastOccurrence};

	}

	private static int getFirstOccurrence(int target, int[] array, int low, int high) {

		if (high < low) {
			return -1;
		}

		int mid = (high - low)/2 + low;

		if ((mid == 0 && target == array[mid])
				|| (target == array[mid] && target > array[mid -1])) {
			return mid;
		}

		if (target > array[mid]) {
			return getFirstOccurrence(target, array, mid + 1, high);
		} else {
			return getFirstOccurrence(target, array, low, mid - 1);
		}

	}

	private static int getLastOccurrence(int target, int[] array, int low, int high) {

		if (high < low) {
			return -1;
		}

		int mid = (high - low)/2 + low;

		if (
				(mid == array.length - 1 && target == array[mid])
						|| (target == array[mid] && target < array[mid + 1])
		) {
			return mid;
		} else if (target < array[mid]) {
			return getLastOccurrence(target, array, low, mid - 1);
		} else {
			return getLastOccurrence(target, array, mid + 1, high);
		}
	}

}
