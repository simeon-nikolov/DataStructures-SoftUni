package ds.home.prob08;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

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
	
	private DoublyLinkedList<E>.Node firstNode;
	private DoublyLinkedList<E>.Node lastNode;
	
	public DoublyLinkedList() {
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
    	DoublyLinkedList<E>.Node newNode = new DoublyLinkedList.Node(item, null, null);
        
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
    	DoublyLinkedList<E>.Node newNode = new DoublyLinkedList.Node(item, null, null);
    	
        if (this.size == 0) {
        	this.firstNode = newNode;
        	this.lastNode = newNode;
        } else {
        	newNode.setPrev(this.lastNode);
        	this.lastNode.setNext(newNode);
        	this.lastNode = newNode;
        }
        
        this.setSize(this.size + 1);
    }

    public E removeFirst() {    	
        if (this.size == 0) {
        	throw new IllegalArgumentException();
        }
        
        E element = null;
    	element = this.firstNode.getValue();
    	this.setSize(this.size - 1);
    	
    	if (this.size == 0) {
    		this.firstNode = null;
    		this.lastNode = null;
    	} else {        		
    		DoublyLinkedList<E>.Node nextNode = this.firstNode.getNext();
    		nextNode.setPrev(null);
    		this.firstNode = nextNode;
    	}
        
        return element;
    }

    public E removeLast() {        
        if (this.size == 0) {
        	throw new IllegalArgumentException();
        }
        
        E element = null;
    	element = this.lastNode.getValue();
    	this.setSize(this.size - 1);
    	
    	if (this.size == 0) {
    		this.firstNode = null;
    		this.lastNode = null;
    	} else {
    		DoublyLinkedList<E>.Node prevNode = this.lastNode.getPrev();
    		prevNode.setNext(null);
    		this.lastNode = prevNode;
    	}
        
        return element;
    }
    
    @SuppressWarnings("unchecked")
	public E[] toArray() {
        Object[] arr = new Object[this.size];
        DoublyLinkedList<E>.Node currentNode = firstNode;
        int index = 0;
        
        while (currentNode != null) {
        	arr[index++] = currentNode.element;
        	currentNode = currentNode.getNext();
        }
        
        return (E[]) arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
        	private DoublyLinkedList<E>.Node currentNode = firstNode;

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
    
    @Override
    public void forEach(Consumer<? super E> action) {
        for (Iterator<E> it = this.iterator(); it.hasNext();) {
        	E element = it.next();
        	action.accept(element);
        }
    }
}

