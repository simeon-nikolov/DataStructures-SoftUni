package ds.home.prob04_linked_stack;

public class LinkedStack<E> {

    private Node firstNode;
    private int size;
    
    public LinkedStack() {
    	this.size = 0;
    }
    
    public int size() {
        return this.size;
    }

    public void push(E element) {
        Node newNode = new Node(element, firstNode);
        this.firstNode = newNode;
        this.size++;
    }

    public E pop() {
        if (this.size == 0) {
        	throw new IllegalArgumentException();
        }
        
        E element = this.firstNode.getValue();
        this.firstNode = this.firstNode.getNextNode();
        this.size--;
        
        return element;
    }

    public E[] toArray() {
       @SuppressWarnings("unchecked")
       E[] array = (E[]) new Object[this.size];
       
       int index = 0;
       Node currentNode = this.firstNode;
       
       while (currentNode != null) {
    	   array[index++] = currentNode.getValue();
    	   currentNode = currentNode.getNextNode();
       }
       
       return array;
    }

    private class Node {
        private E value;
        private Node nextNode;

        public Node(E value) {
           this.value = value; 
        }

        public Node(E value, Node nextNode) {
            this(value);
            this.nextNode = nextNode;
        }
        
        public E getValue() {
        	return this.value;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
