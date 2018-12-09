package ds.lab.prob02;

public class CircularQueue<E> {
	private static final int INITIAL_CAPACITY = 2;
	
	private int first;
	private int last;
	
	private Object[] queue;
    private int size;

    public CircularQueue() {
    	this(INITIAL_CAPACITY);
    }

    public CircularQueue(int initialCapacity) {
    	this.size = 0;
        this.queue = new Object[initialCapacity];
    }

    public int size() {
        return this.size;
    }

    private  void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {    	
        if (this.size == 0) {
        	this.first = 0;
        	this.last = 0;
        	this.queue[first] = element;
        } else {
        	if (this.size >= this.queue.length) {
        		this.resize();
        	}
        	
        	this.last++;
        	
        	if (this.last >= this.queue.length) {
        		this.last = 0;
        	}
        	
        	this.queue[this.last] = element;
        }
        
        this.setSize(this.size + 1);
    }

    private void resize() {
		Object[] newArray = new Object[this.queue.length * 2];
		int length = (this.first < this.last) ? (this.last - this.first + 1) : this.queue.length - this.first;
		System.arraycopy(this.queue, this.first, newArray, 0, length);
		
		if (this.first > this.last) {
			System.arraycopy(this.queue, 0, newArray, length, this.last);			
		}
		
		this.queue = newArray;
	}

	@SuppressWarnings("unchecked")
	public E dequeue() {
		if (this.size == 0) {
			throw new IllegalArgumentException();
		}
		
		E element = (E) this.queue[this.first];
    	this.first++;
    	
    	if (this.first == this.queue.length) {
    		this.first = 0;
    	}
    	
    	this.setSize(this.size - 1);
        return element;
    }

    @SuppressWarnings("unchecked")
	public E[] toArray() {
    	Object[] newArray = new Object[this.size];
		int length = (this.first < this.last) ? (this.last - this.first + 1) : this.queue.length - this.first;
		System.arraycopy(this.queue, this.first, newArray, 0, length);
		
		if (this.first > this.last) {
			System.arraycopy(this.queue, 0, newArray, length, this.last);			
		}
		
		return (E[])newArray;
    }
}
