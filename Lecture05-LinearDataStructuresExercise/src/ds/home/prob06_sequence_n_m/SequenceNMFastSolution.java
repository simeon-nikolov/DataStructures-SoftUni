package ds.home.prob06_sequence_n_m;

import java.util.Scanner;

public class SequenceNMFastSolution {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] numbers = input.split(" ");
			int n = Integer.parseInt(numbers[0]);
			int m = Integer.parseInt(numbers[1]);
			Item item = new Item(m, null);
			
			if (m % 2 == 1 && m > n + 4) { // when m is odd and is not close to n (must be more than n + 4)
				item = new Item(m - 1, item);
			}
			
			while (m >= n) { // loop until a solution is found
				int val = item.getValue();
				
				if (val == n) { // solution found
					print(item);
					break;
				}
				
				if (val - n <= 4) { // close to solution - adjust final steps
					if (val - n > 2) {
						item = new Item(val - 2, item);
						val = item.getValue();
					}
					
					if (val - n > 0) {
						item = new Item(val - (val - n), item);
					}
					
					print(item);
					break;
				} else if (val > 0 && val % 2 == 0 && val / 2 >= n) {
					item = new Item(val / 2, item);
				} else if (val - 1 > n && (val - 1) % 2 == 0 && (val - 1) / 2 >= n && val - 1 > n + 4 && ((val - 1 > 0 && n >= 0) || val - 1 > 4 && n < 0)) {
					item = new Item(val - 1, item);
				} else if (val - 2 >= n) {
					item = new Item(val - 2, item);
				} else if (val - 1 >= n) {
					item = new Item(val - 1, item);
				}
			}
		}
	}
	
	private static void print(Item item) {
		StringBuilder output = new StringBuilder();
		
		while (item != null) {
			output.append(item.getValue());
			item = item.getPrev();
			
			if (item != null) {
				output.append(" -> ");
			}
		}
		
		System.out.println(output);
	}

}

class Item {
	private int value;
	private Item prev;
	
	public Item() { }
	
	public Item(int value) {
		this();
		this.value = value;
	}
	
	public Item(int value, Item prev) {
		this(value);
		this.prev = prev;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Item getPrev() {
		return this.prev;
	}
	
	public void setPrev(Item prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}