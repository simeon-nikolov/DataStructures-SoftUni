package ds.home.prob03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LongestSubsequence {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.nextLine();
			String[] strNumbers = input.split(" ");
			List<Integer> list = new ArrayList<Integer>(strNumbers.length);
			
			for (String strNum : strNumbers) {
				int num = Integer.parseInt(strNum);
				list.add(num);
			}
			
			int maxNumer = list.get(0);
			int maxOccurrences = 1;
			int currOccurrences = 1;
			
			for (int index = 1; index < list.size(); index++) {
				int currNumber = list.get(index);
				
				if (currNumber == list.get(index - 1)) {
					currOccurrences++;
				} else {
					currOccurrences = 1;
				}
				
				if (currOccurrences > maxOccurrences) {
					maxNumer = list.get(index - 1);
					maxOccurrences = currOccurrences;
				}
				
			}
			
			for (int i = 0; i < maxOccurrences; i++) {				
				System.out.print(maxNumer + " ");
			}
		}
	}

}
