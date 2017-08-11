/**
 * 
 */
package practice.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sonin
 *
 */
public class GeneratingBinaryString {

	
	ArrayList<String> output = new ArrayList<>();
	int[] array;
	
	public GeneratingBinaryString(int noOfBits) {
		 array = new int[noOfBits];
	}
	
	public ArrayList<String> getBinaryString(int n) {
		if (n < 1) {
			output.add(Arrays.toString(array));
			System.out.println(Arrays.toString(array));
			}
		else {
			array[n-1] = 0;
			getBinaryString(n-1);
			array[n-1] = 1;
			getBinaryString(n-1);
		}
		
		return output;
	}

}
