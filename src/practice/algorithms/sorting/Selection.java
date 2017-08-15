/**
 * 
 */
package practice.algorithms.sorting;

/**
 * @author sonin
 *
 */
public class Selection {

	private Selection() {}

	public static <T extends Comparable<T>> void sort(T[] a) {
		int n = a.length;

		for (int i=0; i<n; i++) {
			int min=i;
			for (int j=i+1; j<n; j++) {
				if(SortingUtility.less(a[j],a[min])) {
					min = j;
				}
			}
			SortingUtility.exchange(a,min,i);
		}
	}
/*
	public static void main(String... a) {
		String[] arr = {"z","k","o","y","v","r","a","j"};
		Selection.sort(arr);
		for(String i : arr)
			System.out.println(i);
	}

*/}
