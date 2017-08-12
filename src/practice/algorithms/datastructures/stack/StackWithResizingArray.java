/**
 * This implementation with arrays does not require the client to provide the capacity.
 * Average case - constant time for all operations
 * Worst case - push and pop will take time proportional to N (doubling and halving operations)
 * Uses between ~8N to ~32N bytes (8 bytes for reference to array + 24 bytes array overhead when array is one quarter full)
 * Less wasted space 
 */
package practice.algorithms.datastructures.stack;

/**
 * @author sonin
 *
 */
public class StackWithResizingArray {
	
	private String[] strings;
	private int N;
	
	public StackWithResizingArray() {
		strings = new String[1];
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i=0; i<capacity; i++) {
			copy[i] = strings[i];
		}
		strings = copy;
	}
	
	public void push(String item) {
		if (N==strings.length) 
			resize(2 * strings.length);
		
		strings[N++] = item;
	}
	
	public String pop() throws StackUnderFlowException {
		if (N==0) {
			throw new StackUnderFlowException();
		}
		
		String item = strings[--N];
		strings[N] = null;
		if (N>0 && N==strings.length/4) 
			resize(strings.length/2);
		
		return item;
	}
}
