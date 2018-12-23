package ds.home.prob04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RemoveOddOccurrences {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] strNumbers = input.split(" ");
			List<Integer> list = new ArrayList<Integer>(strNumbers.length);
			Map<Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();
			
			for (String strNum : strNumbers) {
				int num = Integer.parseInt(strNum);
				list.add(num);
				
				if (occurrencesMap.get(num) != null) {
					int currOccurrences = occurrencesMap.get(num);
					occurrencesMap.put(num, ++currOccurrences);
				} else {
					occurrencesMap.put(num, 1);
				}
			}
			
			for (Integer num : list) {
				if (occurrencesMap.get(num) % 2 == 0) {
					System.out.print(num + " ");
				}
			}
		}
	}

}
