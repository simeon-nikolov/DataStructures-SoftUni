package ds.lab.prob01.interfaces;

public interface IArrayList<T> {
	/**
	 * Returns the count of the elements
	 * @return count
	 */
	public int getCount();
	/**
	 * Gets the element at position of the given index
	 * @param index
	 * @return element at index
	 */
	public T get(int index);
	/**
	 * Sets new element at the given position by index
	 * @param element
	 * @param index
	 */
	public void set(T element, int index);
	/**
	 * Adds a new element at the end of the list
	 * @param element
	 */
	public void add(T element);
	/**
	 * Removes an element at the given position and returns the removed element
	 * @param index
	 * @return element
	 */
	public T removeAt(int index);
}
