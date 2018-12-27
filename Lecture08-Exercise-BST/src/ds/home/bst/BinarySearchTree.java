package ds.home.bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int nodesCount;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node root) {
        this.preOrderCopy(root);
    }

    private void preOrderCopy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public int getNodesCount() {
        return this.nodesCount;
    }

    public void insert(T value) {
    	if (this.contains(value)) {
    		return;
    	}
    	
        this.nodesCount++;

        if (this.root == null) {
            this.root = new Node(value);
            this.root.count = 1;
            return;
        }

        Node parent = null;
        Node current = this.root;
        while (current != null) {
        	current.count++;
            parent = current;
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return;
            }
        }

        Node newNode = new Node(value);
        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        
        newNode.count = 1 + this.count(newNode.left) + this.count(newNode.right);
    }

    public boolean contains(T value) {
        Node current = this.root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;
        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public Iterable<T> range(T from, T to) {
        Deque<T> queue = new LinkedList<>();
        this.range(this.root, queue, from, to);
        return queue;
    }

    private void range(Node node, Deque<T> queue, T startRange, T endRange) {
        if (node == null) {
            return;
        }

        int compareStart = startRange.compareTo(node.value);
        int compareEnd = endRange.compareTo(node.value);
        if (compareStart < 0) {
            this.range(node.left, queue, startRange, endRange);
        }
        if (compareStart <= 0 && compareEnd >= 0) {
            queue.addLast(node.value);
        }
        if (compareEnd > 0) {
            this.range(node.right, queue, startRange, endRange);
        }
    }

    private T minValue(Node root) {
        T min = root.value;
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }

        return min;
    }

//    public void deleteMin() {
//        if (this.root == null) {
//            throw new IllegalArgumentException("Tree is empty!");
//        }
//
//        Node min = this.root;
//        Node parent = null;
//
//        while (min.left != null) {
//            parent = min;
//            min = min.left;
//        }
//
//        if (parent == null) {
//            this.root = this.root.right;
//        } else {
//            parent.left = min.right;
//        }
//
//        this.nodesCount--;
//    }
    
    public void deleteMin() {
		if (this.root == null) {
			throw new IllegalArgumentException("Tree is empty!");
		}
		
		this.root = this.deleteMin(this.root);
		this.nodesCount--;
    }
    
    private Node deleteMin(Node node) {
    	if (node.left == null) {
    		return node.right;
    	}
    	
    	node.left = deleteMin(node.left);
    	node.count--;
    	
    	return node;
    }

//    public void deleteMax() {
//		 if (this.root == null) {
//			 throw new IllegalArgumentException("Tree is empty!");
//		 }
//    	 
//    	 Node max = this.root;
//    	 Node parent = null;
//    	 
//    	 while (max.right != null) {
//    		 parent = max;
//    		 max = max.right;
//    	 }
//    	 
//    	 if (parent == null) {
//			this.root = this.root.left;
//		} else {
//			parent.right = max.right;
//		}
//    	 
//    	 this.nodesCount--;
//    }
    
    public void deleteMax() {
		if (this.root == null) {
			throw new IllegalArgumentException("Tree is empty!");
		}
		
		this.root = this.deleteMax(this.root);
		this.nodesCount--;
    }
    
    private Node deleteMax(Node node) {
    	if (node.right == null) {
    		return node.left;
    	}
    	
    	node.right = deleteMax(node.right);
    	node.count--;
    	
    	return node;
    }
    
    public int count() {
    	return this.count(this.root);
    }
    
    private int count(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	return node.count;
    }

    public T ceil(T element) {
    	T result = null;
    	Node current = this.root;
    	while (current != null) {
    		int compare = current.value.compareTo(element);
    		
    		if (compare == 0) {
    			result = current.value;
    			break;
    		}
    		
    		if (compare < 0) {
    			current = current.right;
    		} else if (compare > 0) {
    			result = current.value;
    			current = current.left;
    		}
    	}
    	
    	return result;
    }

    public T floor(T element) {
    	T result = null;
    	Node current = this.root;
    	while (current != null) {
    		int compare = current.value.compareTo(element);
    		
    		if (compare == 0) {
    			result = current.value;
    			break;
    		}
    		
    		if (compare > 0) {
    			current = current.left;
    		} else if (compare < 0) {
    			result = current.value;
    			current = current.right;
    		}
    	}
    	
    	return result;
    }

    public void delete(T key) {
    	if (key == null) {
			throw new IllegalArgumentException("key can not be null");
		}
        
        if (this.root == null) {
			throw new IllegalArgumentException("Tree is empty!");
		}
        
        if (this.contains(key)) {
        	Node oldRoot = this.root;
        	this.root = null;
        	this.nodesCount = 0;
        	
        	if (oldRoot.value.compareTo(key) == 0) { // root element is deleted
        		Node newRoot = this.findNewRoot(oldRoot);
	        	this.insert(newRoot.value);
	        	this.delete(key, oldRoot, newRoot);
        	} else {
	        	this.insert(oldRoot.value);
	        	this.delete(key, oldRoot, oldRoot);
        	}
        }
    }
    
    private void delete(T element, Node node, Node newRoot) {
        if (node == null) {
            return;
        }
        
        if (element != node.value && node.value != newRoot.value) {
        	this.insert(node.value);
        }
        
        this.delete(element, node.left, newRoot);
        this.delete(element, node.right, newRoot);
    }
    
    private Node findNewRoot(Node oldRoot) {
		T currentRootValue = oldRoot.value;
		Node newRoot = null;
		
		// try to find ceil
		Node current = oldRoot.right;
    	while (current != null) {
    		int compare = current.value.compareTo(currentRootValue);
    		
    		if (compare < 0) {
    			current = current.right;
    		} else if (compare > 0) {
    			newRoot = current;
    			current = current.left;
    		}
    	}
    	
    	if (newRoot == null) { // not found yet
    		// try to find floor to the old root
    		current = oldRoot.left;
        	while (current != null) {
        		int compare = current.value.compareTo(currentRootValue);
        		
        		if (compare > 0) {
        			current = current.left;
        		} else if (compare < 0) {
        			newRoot = current;
        			current = current.right;
        		}
        	}
    	}
    	
		return newRoot;
	}

    public int rank(T item) {
        if (item == null) {
			throw new IllegalArgumentException("item can not be null");
		}
        
        if (this.root == null) {
			throw new IllegalArgumentException("Tree is empty!");
		}
        
    	return this.rank(item, this.root);
    }
    
    private int rank(T element, Node node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	int compare = element.compareTo(node.value);
    	
    	if (compare < 0) {
    		return this.rank(element, node.left);
    	}
    	
    	if (compare > 0) {
    		return 1 + this.count(node.left) + this.rank(element, node.right);
    	}
    	
    	return this.count(node.left);
    }

    public T select(int n) {
    	if (n < 0) {
    		throw new IllegalArgumentException("\"n\" can not be negative!");
    	}
        
    	if (this.root == null) {
    		throw new IllegalArgumentException("Tree is empty!");
    	}
        
        T foundElement = null;
        Node current = this.root;
        while (current != null) {
			int rank = this.rank(current.value);
			
			if (n == rank) { // found
				foundElement = current.value;
				break;
			}
			
			if (n < rank) {
				current = current.left;
			} else if (n > rank) {
				current = current.right;
			}
		}
        
        return foundElement;
    }

    class Node {
        private T value;
        private Node left;
        private Node right;
        
        private int count;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}

