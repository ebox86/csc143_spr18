package CallCenter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of Queue with a HashSet method
 * 
 * @author evankoh
 * @version csc143
 * @param <T>
 *            - the type of the HashSet used
 */
public class HashQueue<T> {

	private int size;
	private Node<T> front, end;
	private HashSet<T> hashset;

	/**
	 * Default constructor which creates a new List with initial size of 0
	 */
	public HashQueue() {
		this.size = 0;
		this.hashset = new HashSet<T>();
	}

	/**
	 * Adds a new object of type T to the queue
	 * 
	 * @param t
	 *            - the object passed
	 */
	public void push(T t) {
		Node<T> node = new Node<T>(t);
		if (!hashset.contains(t)) {
			hashset.add(t);
			if (end != null)
				end.next = node;
			end = node;
			if (front == null) {
				front = node;
			}
			this.size += 1;
		}
	}

	/**
	 * Determines whether or not the queue is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Returns the total number of items in the queue
	 * 
	 * @return the int of total items in list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Clears the queue
	 */
	public void clear() {
		front = null;
		end = null;
		size = 0;
	}

	/**
	 * Returns the item least recently added to this queue.
	 *
	 * @return the item least recently added to this queue
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue empty");
		}
		return front.data;
	}

	/**
	 * Removes an element of type T from the queue
	 */
	public T pop() {
		if (front == null) {
			return null;
		}
		T value = front.data;
		front = front.next;
		if (front == null) {
			end = null;
		}
		hashset.remove(value);
		size--;
		return value;
	}

	/*
	 * Implements an Iterator for the queue
	 */
	private class QueueIterator implements Iterator<T> {
		private Node<T> current = front;
		private int index = 0;

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				index++;
				T temp = current.data;
				current = current.next;
				return temp;
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Iterator for Iterable interface
	 */
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	/*
	 * Generic Node class used for queue
	 */
	private class Node<E> implements Serializable {

		private static final long serialVersionUID = 1L;
		private T data;
		private Node<T> next;

		public Node(T t) {
			this.data = t;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public boolean equals(Node<T> node) {
			if (this.data.equals(node.data)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
