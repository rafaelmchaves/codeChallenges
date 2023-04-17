package binarysearch;

public class KeyExpression {

	public static void main(String[] args) {

		final var array = new String[]{"att", "attualization", "Boratt", "boratt", "Car"};

		System.out.println("first element: " + findFirstKeyExpression("bor", array, 0, array.length - 1));
	}

	public static int findFirstKeyExpression(String target, String[] array, int low, int high) {

		if (array == null || array.length == 0 || high < low ) {
			return -1;
		}

		final int mid = (high - low)/2 + low;

		if ((mid == 0 || !array[mid - 1].contains(target)) && array[mid].contains(target)) {
			return mid;
		} else if (target.compareTo(array[mid]) > 0) {
			return findFirstKeyExpression(target, array, mid + 1, high);
		} else {
			return findFirstKeyExpression(target, array, low, mid - 1);
		}

	}
}
