/**
 * 
 */
package practice.algorithms.backtracking;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author sonin
 *
 */
public class TestGeneratingAllBinaryStrings {

	@Test
	public void testGenerateBinaryStringOf2bits() {
		int noOfBits = 2;
		GeneratingBinaryString generator = new GeneratingBinaryString(noOfBits);
		ArrayList<String> actualResult = generator.getBinaryString(noOfBits);
		
		ArrayList<String> expectedResult = new ArrayList();
		expectedResult.add("[0, 0]");
		expectedResult.add("[1, 0]");
		expectedResult.add("[0, 1]");
		expectedResult.add("[1, 1]");
		
		
		// Validations
		assertEquals("Size of array list should be 4", 4, actualResult.size());
		assertEquals(expectedResult, actualResult);
		
	}

}
