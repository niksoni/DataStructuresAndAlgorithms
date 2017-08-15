/**
 * 
 */
package practice.algorithms.sorting;

/**
 * @author sonin
 *
 */
public class SortingUtility {

	private SortingUtility() {

	}

	public static <T extends Comparable<T>>boolean less(T a, T b) {
		return a.compareTo(b) < 0;
	}

	public static <T> void exchange(Comparable<T>[] arr, int i, int j) {
		Comparable<T> swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}

	public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (less(arr[i], arr[i-1]))
				return false;
		}
		return true;
	}
}
