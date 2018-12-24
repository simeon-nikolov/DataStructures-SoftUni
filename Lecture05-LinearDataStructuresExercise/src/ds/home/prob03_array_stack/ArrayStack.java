package ds.home.prob03_array_stack;

public class ArrayStack<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public void push(T element) {
        if (this.size == this.elements.length) {
        	this.grow();
        }
        
        this.elements[this.size++] = element;
    }

    public T pop() {
    	if (this.size == 0) {
    		throw new IllegalArgumentException();
    	}
    	
        return this.elements[--this.size];
    }

    public T[] toArray() {
    	@SuppressWarnings("unchecked")
		T[] returnArray = (T[]) new Object[this.size];
        
    	for (int index = 0; index < this.size; index++) {
			returnArray[index] = this.elements[this.size - index - 1];
		}
    	
        return returnArray;
    }

    private void grow() {
        @SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[this.elements.length * 2];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
        this.elements = newArray;
    }

}
