package ku;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class that iterate any type of element.
 * 
 * @author Pawan Intawongsa
 *
 * @param <T>
 *            type of array
 */
public class ArrayIterator<T> implements Iterator<T> {
	private T[] array;
	private int cursor;
	private boolean legal = false;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
	}

	/**
	 * Check that array has a next element.
	 * 
	 * @return if it has return true if not return false
	 */
	@Override
	public boolean hasNext() {
		for (cursor = 0; cursor < array.length && array[cursor] == null;) {
			cursor++;
		}
		if (cursor < array.length && array[cursor] != null) {
			return true;
		} else
			return false;

	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			cursor++;
			return array[cursor - 1];
		} else
			throw new NoSuchElementException();
	}

	/**
	 * Remove recent array's element and set it to null.
	 */
	public void remove() {
		if (legal) {
			this.array[cursor - 1] = null;
			legal = false;
		} else
			throw new IllegalStateException();
	}

}
