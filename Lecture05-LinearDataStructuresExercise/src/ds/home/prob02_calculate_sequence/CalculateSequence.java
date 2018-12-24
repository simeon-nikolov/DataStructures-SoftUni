package ds.home.prob02_calculate_sequence;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CalculateSequence {
	private static final int MAX_ELEMENTS = 50;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int startNumber = sc.nextInt();
			int count = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(startNumber);
			StringBuilder output = new StringBuilder();
			
			while (count < MAX_ELEMENTS) {
				int currNumber = queue.remove();
				output.append(currNumber);
				
				if (count + 1 < MAX_ELEMENTS) {
					output.append(", ");
				}
				
				queue.add(currNumber + 1);
				queue.add(2 * currNumber + 1);
				queue.add(currNumber + 2);
				count++;
			}
			
			System.out.println(output);
		}
	}

}
