package ds.home.prob02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortWords {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] words = input.split(" ");
			List<String> list = new ArrayList<String>(words.length);
					
			for (String word : words) {
				list.add(word);
			}
			
			Collections.sort(list);
			
			for (String word : list) {
				System.out.print(word + " ");
			}
		}
	}

}
