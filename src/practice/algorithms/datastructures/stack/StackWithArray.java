/**
 * This implementation has a cheat to take the capacity from the client.
 * To remove this constraint - use re-sizing array implementation of stack
 */
package practice.algorithms.datastructures.stack;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class StackWithArray<T> {
	
	private T[] items;
	private int n = 0;
	
	@SuppressWarnings("unchecked")
	public StackWithArray(int capacity) {
		items = (T[]) new Object[capacity];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public void push(T item) {
		items[n++] = item;
	}
	
	public T pop() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		T item = items[--n];
		items[n] = null;
		return item;
	}
}
