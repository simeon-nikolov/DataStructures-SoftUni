package ds.home.prob05_linked_queue;

public class LinkedQueue<E> {

	private Node firstNode;
	private Node lastNode;
    private int size;
    
    public LinkedQueue() {
    	this.size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public void enqueue(E element) {
    	Node newNode = new Node(element);
        
    	if (this.size == 0) {
        	this.firstNode = this.lastNode = newNode;
        } else {
        	newNode.setPrevNode(this.lastNode);
        	this.lastNode.setNextNode(newNode);
        	this.lastNode = newNode;
        }
    	
    	this.size++;
    }

    public E dequeue() {
        if (this.size == 0) {
        	throw new IllegalArgumentException();
        }
        
        E element = firstNode.getValue();
        this.firstNode = this.firstNode.getNextNode();
        this.size--;
        
        return element;
    }

    public E[] toArray() {
        @SuppressWarnings("unchecked")
		E[] array = (E[]) new Object[this.size];
        
        Node currentNode = this.firstNode;
        int index = 0;
        
        while (currentNode != null) {
        	array[index++] = currentNode.getValue();
        	currentNode = currentNode.getNextNode();
        }
        
        return array;
    }

    private class Node {
        private E value;

        private Node nextNode;
        private Node prevNode;
        
        public Node(E value) {
        	this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }
    }
}
