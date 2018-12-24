package ds.home.prob06_sequence_n_m;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SequenceNMWithQueue {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] numbers = input.split(" ");
			int n = Integer.parseInt(numbers[0]);
			int m = Integer.parseInt(numbers[1]);
			Deque<QueueItem> queue = new LinkedList<QueueItem>();
			queue.add(new QueueItem(n, null));
			
			while (!queue.isEmpty()) {				
				// check if solution is found
				QueueItem last = queue.getLast();
				
				if (last.getValue() == m) { // solution found
					print(last);
					break;
				}
				
				// continue with finding solution
				QueueItem item = queue.remove();
				
				if (item.getValue() + 1 <= m) {
					queue.add(new QueueItem(item.getValue() + 1, item));
				}
				
				if (item.getValue() + 2 <= m) {
					queue.add(new QueueItem(item.getValue() + 2, item));
				}
				
				if (item.getValue() * 2 <= m && item.getValue() > 0) {
					queue.add(new QueueItem(item.getValue() * 2, item));
				}
			}
		}
	}

	private static void print(QueueItem item) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while (item != null) {
			stack.add(item.getValue());
			item = item.getPrev();
		}
		
		StringBuilder output = new StringBuilder();
		
		while (!stack.isEmpty()) {
			output.append(stack.pop());
			
			if (!stack.isEmpty()) {
				output.append(" -> ");
			}
		}
		
		System.out.println(output);
	}

}

class QueueItem {
	private int value;
	private QueueItem prev;
	
	public QueueItem() { }
	
	public QueueItem(int value) {
		this();
		this.value = value;
	}
	
	public QueueItem(int value, QueueItem prev) {
		this(value);
		this.prev = prev;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public QueueItem getPrev() {
		return this.prev;
	}
	
	public void setPrev(QueueItem prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}