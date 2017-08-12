/**
 * This implementation has a cheat to take the capacity from the client.
 * To remove this constraint - use re-sizing array implementation of stack
 */
package practice.algorithms.datastructures.stack;

/**
 * @author sonin
 *
 */
public class StackWithArray {
	
	private String[] strings;
	private int N = 0;
	
	public StackWithArray(int capacity) {
		strings = new String[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		strings[N++] = item;
	}
	
	public String pop() throws StackUnderFlowException {
		if (N==0) {
			throw new StackUnderFlowException();
		}
		String item = strings[--N];
		strings[N] = null;
		return item;
	}
}
