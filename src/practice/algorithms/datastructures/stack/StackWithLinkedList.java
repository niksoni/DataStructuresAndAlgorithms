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

/**
 * @author sonin
 *
 */
public class StackWithLinkedList {
	
	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public String pop() throws StackUnderFlowException {
		if (first == null) {
			throw new StackUnderFlowException();
		}
		String item = first.item;
		first = first.next;
		return item;
	}

}
