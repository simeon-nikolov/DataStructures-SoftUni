package ds.home.prob01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumAndAvarage {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
			List<Integer> list = new LinkedList<Integer>();
			
			int sum = 0;
			
			for (String strNum : numbers) {
				int num = Integer.parseInt(strNum);
				list.add(num);
				sum += num;
			}
			
			double avarage = sum / (double) list.size();
			
			System.out.println(String.format("Sum=%d; Average=%.2f", sum, avarage));
		}
	}

}
