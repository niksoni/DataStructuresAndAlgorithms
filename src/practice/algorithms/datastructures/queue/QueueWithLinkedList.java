/**
 * 
 */
package practice.algorithms.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class QueueWithLinkedList<T> implements Iterable<T>{

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

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			T item= current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}