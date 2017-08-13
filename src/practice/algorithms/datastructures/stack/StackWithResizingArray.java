/**
 * This implementation with arrays does not require the client to provide the capacity.
 * Average case - constant time for all operations
 * Worst case - push and pop will take time proportional to N (doubling and halving operations)
 * Uses between ~8N to ~32N bytes (8 bytes for reference to array + 24 bytes array overhead when array is one quarter full)
 * Less wasted space 
 */
package practice.algorithms.datastructures.stack;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class StackWithResizingArray<T> {
	
	private T[] items;
	private int n;
	
	@SuppressWarnings("unchecked")
	public StackWithResizingArray() {
		items = (T[]) new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		T[] copy = (T[]) new Object[capacity];
		for (int i=0; i<capacity; i++) {
			copy[i] = items[i];
		}
		items = copy;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public void push(T item) {
		if (n==items.length) 
			resize(2 * items.length);
		
		items[n++] = item;
	}
	
	public T pop() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		
		T item = items[--n];
		items[n] = null;
		if (n>0 && n==items.length/4) 
			resize(items.length/2);
		
		return item;
	}
}
