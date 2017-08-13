/**
 * every operation takes constant time in the worst case
 * A stack with N items uses ~40N bytes - 
 * 				16 bytes object overhead +
 * 				8 bytes inner class overhead +
 * 				8 bytes string reference
 * 				8 bytes Node reference
 * Uses extra time and space to deal with the links   
 */
package practice.algorithms.datastructures.stack;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class StackWithLinkedList<T> {
	
	private Node first = null;
	
	private class Node {
		T item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void push(T item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public T pop() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		T item = first.item;
		first = first.next;
		return item;
	}

}
