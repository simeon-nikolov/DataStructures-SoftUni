package ds.lab.prob01;

import java.util.Arrays;

import ds.lab.prob01.interfaces.IArrayList;

public class ArrayList<T> implements IArrayList<T> {
	private static final int INITIAL_CAPACITY = 2;
	
	private int count;
	private Object[] list;
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int capacity) {
		this.count = 0;
		this.list = new Object[capacity];
	}

	@Override
	public int getCount() {
		return this.count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || this.count <= index) {
			throw new IndexOutOfBoundsException();
		}
		
		return (T) this.list[index];
	}

	@Override
	public void set(T element, int index) {
		if (index < 0 || this.count <= index) {
			throw new IndexOutOfBoundsException();
		}
		
		this.list[index] = element;
	}

	@Override
	public void add(T element) {
		if (this.count >= this.list.length) {
			this.resizeList();
		}
		
		this.list[this.count++] = element;
	}

	@Override
	public T removeAt(int index) {
		if (index < 0 || this.count <= index) {
			throw new IndexOutOfBoundsException();
		}
		
		@SuppressWarnings("unchecked")
		T element = (T) this.list[index];
		this.shift(index);		
		
		this.count--;
		
		if (this.count < this.list.length / 4) {
			this.shrink();
		}
		
		return element;
	}

	
	@Override
	public String toString() {
		Object[] arrayToPrint = new Object[this.count];
		System.arraycopy(this.list, 0, arrayToPrint, 0, this.count);
		return Arrays.toString(arrayToPrint);
	}

	private void shift(int index) {
		for (int arrIndex = index; arrIndex < list.length - 1; arrIndex++) {
			this.list[arrIndex] = this.list[arrIndex + 1];
		}
	}
	
	private void shrink() {
		Object[] newArray = new Object[this.list.length / 2];
		System.arraycopy(this.list, 0, newArray, 0, this.list.length);
		this.list = newArray;
	}

	private void resizeList() {
		Object[] newArray = new Object[this.list.length * 2];
		System.arraycopy(this.list, 0, newArray, 0, this.list.length);
		this.list = newArray;
	}
}
