package ds.home.prob01_reverse_numbers;

import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] numbers = input.split(" ");
			Stack<String> stack = new Stack<String>();
			
			for (String num : numbers) {
				stack.push(num);
			}
			
			StringBuilder output = new StringBuilder();
			
			while (!stack.empty()) {
				output.append(stack.pop() + " ");
			}
			
			System.out.println(output);
		}
	}

}
