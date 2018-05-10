package JavaWord;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a generic doubly linked list in java
 * 
 * @author evankoh
 * @version csc143
 * @param <T>
 *            - the Type of the DoublyLinkedList
 */
public class DoublyLinkedList<T> implements Serializable, Iterable<T> {

	private static final long serialVersionUID = 6758381385650663290L;
	private int size;
	private Node<T> front, end;

	/**
	 * Default constructor which creates a new List with initial size of 0
	 */
	public DoublyLinkedList() {
		this.size = 0;
	}

	/**
	 * Adds a new object of type T to the linked list
	 * 
	 * @param t
	 *            - the object passed
	 */
	public void addAtFront(T t) {
		Node<T> node = new Node<T>(t);
		if (front == null) {
			front = node;
		} else {
			front.setPrev(node);
			node.setNext(front);
			front = node;
		}
		if (end == null) {
			end = node;
		}
		size += 1;
	}

	/**
	 * Returns the total number of items in the list
	 * 
	 * @return the int of total items in list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Adds a new object of type T to the back of the linked list
	 * 
	 * @param t
	 *            - the object passed
	 */
	public void addAtEnd(T t) {
		Node<T> node = new Node<T>(t);
		if (end == null) {
			end = node;
		} else {
			end.setNext(node);
			node.setPrev(end);
			end = node;
		}
		if (front == null) {
			front = node;
		}
		size += 1;
	}

	/**
	 * Removes an element of type T from the list
	 * @param t - the element to remove
	 */
	public void remove(T t) {
		Node<T> nodeToFind = new Node<T>(t);
		Node<T> temp = front;
		while (temp != null) {
			if (temp.equals(nodeToFind)) {
				Node<T> found = temp;
				Node<T> beforeFound = found.getPrev();
				Node<T> afterFound = found.getNext();
				if (beforeFound == null && afterFound == null) {
					clear();
				} else if (beforeFound == null) {
					afterFound.setPrev(null);
					front = afterFound;
				} else if (afterFound == null) {
					beforeFound.setNext(null);
					end = beforeFound;
				} else {
					beforeFound.setNext(afterFound);
					afterFound.setPrev(beforeFound);
				}
				size--;
			}
			temp = temp.getNext();
		}
	}

	public void clear() {
		front = null;
		end = null;
		size = 0;
	}

	/*
	 * Generic Node class used for doubly linked list
	 */
	private class Node<E> implements Serializable {

		private static final long serialVersionUID = 1L;
		private T data;
		private Node<T> next, prev;

		public Node(T t) {
			this.data = t;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public boolean equals(Node<T> node) {
			if (this.data.equals(node.data)) {
				return true;
			} else {
				return false;
			}
		}
	}


	/*
	 * Implements an Iterator for the DoublyLinkedList
	 */
	private class DoubleListIterator implements Iterator<T> {
		// instance variable
		private DoublyLinkedList<T>.Node<T> current = front;
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
	@Override
	public Iterator<T> iterator() {
		return new DoubleListIterator();
	}
}
