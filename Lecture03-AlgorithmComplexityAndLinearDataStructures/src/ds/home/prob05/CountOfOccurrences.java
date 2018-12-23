package ds.home.prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOfOccurrences {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] strNumbers = input.split(" ");
			Map<Integer, Integer> occurrencesMap = new TreeMap<Integer, Integer>();
			
			for (String strNum : strNumbers) {
				int num = Integer.parseInt(strNum);
				
				if (occurrencesMap.get(num) != null) {
					int currOccurrences = occurrencesMap.get(num);
					occurrencesMap.put(num, ++currOccurrences);
				} else {
					occurrencesMap.put(num, 1);
				}
			}
			
			for (Integer num : occurrencesMap.keySet()) {
				int count = occurrencesMap.get(num);
				System.out.println(num + " -> " + count + " times");
			}
		}
	}
}
