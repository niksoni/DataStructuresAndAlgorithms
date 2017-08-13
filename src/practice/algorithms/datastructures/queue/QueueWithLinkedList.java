/**
 * 
 */
package practice.algorithms.datastructures.queue;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class QueueWithLinkedList<T> {

	private Node first;
	private Node last;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(T item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty()) {
			first = last;
		}
		else {
			oldLast.next = last;
		}
	}

	public T dequeue() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}
		T item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

}
