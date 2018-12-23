package ds.lab.prob01;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

	private class Node {
		private E element;
		private Node next;
		private Node prev;
		
		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		
		public E getValue() {
			return this.element;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getPrev() {
			return this.prev;
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}
	
	private LinkedList<E>.Node firstNode;
	private LinkedList<E>.Node lastNode;
	
	public LinkedList() {
		this.setSize(0);
	}
	
    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
    	@SuppressWarnings({ "rawtypes", "unchecked" })
		LinkedList<E>.Node newNode = new LinkedList.Node(item, null, null);
        
    	if (this.size == 0) {
        	this.firstNode = newNode;
        	this.lastNode = newNode;
        } else {
        	newNode.setNext(firstNode);
        	firstNode.setPrev(newNode);
        	this.firstNode = newNode;
        }
    	
    	this.setSize(this.size + 1);
    }

    public void addLast(E item) {
    	@SuppressWarnings({ "rawtypes", "unchecked" })
		LinkedList<E>.Node newNode = new LinkedList.Node(item, null, null);
    	
        if (this.size == 0) {
        	this.firstNode = newNode;
        	this.lastNode = newNode;
        } else {
        	newNode.setPrev(lastNode);
        	lastNode.setNext(newNode);
        	this.lastNode = newNode;
        }
        
        this.setSize(this.size + 1);
    }

    public E removeFirst() {
    	E element = null;
    	
        if (this.size > 0) {
        	element = this.firstNode.getValue();
        	this.setSize(this.size - 1);
        	
        	if (this.size == 0) {
        		this.firstNode = null;
        		this.lastNode = null;
        	} else {        		
        		LinkedList<E>.Node nextNode = this.firstNode.getNext();
        		nextNode.setPrev(null);
        		this.firstNode = nextNode;
        	}
        }
        
        return element;
    }

    public E removeLast() {
        E element = null;
        
        if (this.size > 0) {
        	element = this.lastNode.getValue();
        	this.setSize(this.size - 1);
        	
        	if (this.size == 0) {
        		this.firstNode = null;
        		this.lastNode = null;
        	} else {
        		LinkedList<E>.Node prevNode = this.lastNode.getPrev();
        		prevNode.setNext(null);
        		this.lastNode = prevNode;
        	}
        }
        
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
        	private LinkedList<E>.Node currentNode = firstNode;

			@Override
			public boolean hasNext() {
				return this.currentNode != null;
			}

			@Override
			public E next() {
				E result = this.currentNode.getValue();
				this.currentNode = this.currentNode.getNext();
				return result;
			}
		};
    }

}
