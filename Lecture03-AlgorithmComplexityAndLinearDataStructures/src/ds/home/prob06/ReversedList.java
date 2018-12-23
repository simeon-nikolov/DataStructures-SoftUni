package ds.home.prob06;

public class ReversedList<T> {
	private static final int INITIAL_CAPACITY = 2;
	
	private int first;
	private int last;
	
	private Object[] list;
    private int count;

    public ReversedList() {
    	this(INITIAL_CAPACITY);
    }

    public ReversedList(int initialCapacity) {
    	this.count = 0;
        this.list = new Object[initialCapacity];
    }

    public int count() {
        return this.count;
    }

    public int capacity() {
    	return this.list.length;
    }
    
    @SuppressWarnings("unchecked")
	public T get(int index) {
    	int reveresedIndex = this.count - index - 1;
    	int actualIndex = (this.first + reveresedIndex) % this.count;
    	return (T) this.list[actualIndex];
    }
    
    public void set(int index, T element) {
    	int reveresedIndex = this.count - index - 1;
    	int actualIndex = (this.first + reveresedIndex) % this.count;
    	this.list[actualIndex] = element;
    }

    public void add(T element) {    	
        if (this.count == 0) {
        	this.first = 0;
        	this.last = 0;
        	this.list[first] = element;
        } else {
        	if (this.count >= this.list.length) {
        		this.resize();
        	}
        	
        	this.last++;
        	
        	if (this.last >= this.list.length) {
        		this.last = 0;
        	}
        	
        	this.list[this.last] = element;
        }
        
        this.count++;
    }

    private void resize() {
		Object[] newArray = new Object[this.list.length * 2];
		int length = (this.first < this.last) ? (this.last - this.first + 1) : this.list.length - this.first;
		System.arraycopy(this.list, this.first, newArray, 0, length);
		
		if (this.first > this.last) {
			System.arraycopy(this.list, 0, newArray, length, this.last);			
		}
		
		this.list = newArray;
	}

	@SuppressWarnings("unchecked")
	public void removeAt(int index) {
		this.count = 0;
    }

    
}
