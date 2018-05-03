package drawingApp;

import java.io.Serializable;
import java.util.*;
/**
 * Generic ArrayList -- starting capacity 100
 *
 * @param <E> the type of the elements
 * @version csc143
 */
public class ArrayList<E> implements Serializable, Iterable<E>{

	private static final long serialVersionUID = 7330096336646780548L;
	private E[] elementData;
    private int size;

    public static final int DEFAULT_CAPACITY = 100;

    /**
     * Default constructor -- constructs new arrayList of default value
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    
    /**
     * Constructor which takes initial size as a parameter
     * @param capacity of the new ArrayList
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * size - Returns the current number of elements in the arrayList
     * @return the size of the arrayList
     */
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    /**
     * get - returns an element from the arraylist given an index position
     * @param the index position of the element
     * @return the element
     */
    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * creates a string representation of the list, with comma 
     * separated elements and brackets
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    
    /**
     * indexOf - returns index position of an element in the arrayList
     * @param An arrayList element
     * @return the index position of the element in the arrayList
     */
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * isEmpty - returns true if list is empty, false if not
     * @return true or false if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    /**
     * Returns boolean if the arrayList contains an element or not
     * @param value of element to check for
     * @return true or false, depending on if the element exists
     */
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    /**
     * add - adds an element to the arrayList
     * @param the element to add
     */
    public void add(E value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    /**
     * add - adds an element to the arraylist at a given index position
     * @param the index position to add the element at
     * @param the element to add
     */
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    /**
     * remove - removes an element from the arraylist at a given index position
     * @param the index position of the element to remove
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    /**
     * set - changes a value of a given arraylist index to the element specified
     * @param the index position of the element to change
     * @param the element to set the index position to
     */
    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    /**
     * clears the arrayList
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // post: appends all values in the given list to the end of this list
    /**
     * addAll - adds all elements in the given list to the end of the arraylist
     * @param the list of elements to add
     */
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // post: returns an iterator for this list
    /**
     * returns an iterator for the list
     */
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    /**
     * ensureCapacity - ensures that the arraylist has enough capacity in the base array
     * in order to add more elements
     * @param the amount of space that needs to be checked for
     */
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private class ArrayListIterator implements Iterator<E> {
        private int position;           // current position within the list
        private boolean removeOK;       // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < size();
        }

        // pre : hasNext() (throws NoSuchElementException if not)
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (throws
        //       IllegalStateException if not)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }
}
