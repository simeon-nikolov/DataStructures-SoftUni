package ds.lab.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node root;

	public BinarySearchTree() {
	}
	
	public BinarySearchTree(Node root) {
		this.copy(root);
	}

	private void copy(Node node) {
		if (node == null) {
			return;
		}
		
		this.insert(node.getValue());
		this.copy(node.getLeft());
		this.copy(node.getRight());
	}

	public Node getRoot() {
		return this.root;
	}

	public void insert(T value) {
		if (value == null) {
			return;
		}
		
		if (this.root == null) {
			this.root = new Node(value);
			return;
		}
		
		Node parent = null;
		Node current = this.root;
		
		while (current != null) {
			if (value.compareTo(current.getValue()) < 0) {
				parent = current;
				current = current.getLeft();
			} else if (value.compareTo(current.getValue()) > 0) {
				parent = current;
				current = current.getRight();
			} else {
				break;
			}
		}
		
		Node newNode = new Node(value);
		if (value.compareTo(parent.getValue()) < 0) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
	}

	public boolean contains(T value) {
		if (value == null) {
			return false;
		}
		
		Node current = this.root;
		
		while (current != null) {
			if (value.compareTo(current.value) < 0) {
				current = current.getLeft();
			} else if (value.compareTo(current.value) > 0) {
				current = current.getRight();
			} else {
				break;
			}
		}
		
		return current != null;
	}

	public BinarySearchTree<T> search(T item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		Node current = this.root;
		
		while (current != null) {
			if (item.compareTo(current.getValue()) < 0) {
				current = current.getLeft();
			} else if (item.compareTo(current.getValue()) > 0) {
				current = current.getRight();
			} else {
				break;
			}
		}
		
		return new BinarySearchTree<>(current);
	}

	public void eachInOrder(Consumer<T> consumer) {
		if (this.root == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		Node current = this.root;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			consumer.accept(current.getValue());
			current = current.right;
		}
	}

	public Iterable<T> range(T from, T to) {
		Queue<T> queue = new LinkedList<T>();
		
		this.range(this.root, queue, from, to);
		
		return queue;
	}

	private void range(Node node, Queue<T> queue, T from, T to) {
		if (node == null) {
			return;
		}
		
		int nodeInLowerRange = from.compareTo(node.getValue());
		int nodeInHigherRange = to.compareTo(node.getValue());
		
		if (nodeInLowerRange < 0) {
			this.range(node.getLeft(), queue, from, to);
		}
		if (nodeInLowerRange <= 0 && nodeInHigherRange >= 0) {
			queue.add(node.getValue());
		}
		if (nodeInHigherRange > 0) {
			this.range(node.getRight(), queue, from, to);
		}
	}

	class Node {
		private T value;
		private Node left;
		private Node right;

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
	}
}
