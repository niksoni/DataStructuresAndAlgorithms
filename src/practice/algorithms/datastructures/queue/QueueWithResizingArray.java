/**
 *
 **/
package practice.algorithms.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import practice.algorithms.datastructures.UnderFlowException;

/**
 * @author sonin
 *
 */
public class QueueWithResizingArray<T> implements Iterable<T>{

	private T[] items;
	private int head;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueWithResizingArray() {
		items = (T[]) new Object[1];
	}

	@SuppressWarnings("unchecked")
	private void resetAndResize(int capacity) {
		T[] copy = (T[]) new Object[capacity];
		int i = 0;
		for (int j=0; j<items.length; j++) {
			if (items[j] != null) {
				copy[i] = items[j];
				tail = ++i;
			}
		}
		items = copy;
		head = 0;
	}

	public boolean isEmpty() {
		return head == 0;
	}

	public void push(T item) {
		int currentCapacity = tail-head;
		if (currentCapacity>0 && currentCapacity==items.length/4) {
			resetAndResize(2 * items.length);
		}

		if (tail==items.length) {
			resetAndResize(items.length);
		}

		items[tail++] = item;
	}

	public T pop() throws UnderFlowException {
		if (isEmpty()) {
			throw new UnderFlowException();
		}

		T item = items[head];
		items[head] = null;
		head++;
		int currentCapacity = tail-head;
		if (currentCapacity>0 && currentCapacity==items.length/4) {
			resetAndResize(items.length/2);
		}
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<T> {

		private int i = head;

		@Override
		public boolean hasNext() {
			return i < tail;
		}

		@Override
		public T next() {
			if (i >= tail) {
				throw new NoSuchElementException();
			}
			return items[i++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}