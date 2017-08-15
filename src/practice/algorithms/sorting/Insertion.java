/**
 * 
 */
package practice.algorithms.sorting;

/**
 * @author sonin
 *
 */
public class Insertion {

	private Insertion() {}

	public static <T extends Comparable<T>> void sort(T[] a) {
		int n = a.length;

		for (int i=0; i<n; i++) {
			for (int j=i; j>0; j--) {
				if(SortingUtility.less(a[j],a[j-1])) {
					SortingUtility.exchange(a,j,j-1);
				}
				else
					break;
			}
		}
	}
}
