package ds.home.prob07;

import java.util.LinkedList;
import java.util.Scanner;

public class DistanceInLabyrinth {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int length = Integer.parseInt(sc.nextLine());
			String[][] maze = new String[length][length];
			int startRow = 0;
			int startCol = 0;
			
			for (int row = 0; row < length; row++) {
				String input = sc.nextLine();
				
				for (int col = 0; col < length; col++) {
					char ch = input.charAt(col);
					maze[row][col] = String.valueOf(ch);
					
					if (ch == '*') {
						startRow = row;
						startCol = col;
					}
				}
			}
			
			int steps = 0;
			LinkedList<Cell> queue = new LinkedList<Cell>();
			Cell root = new Cell(startRow, startCol, steps);
			queue.add(root);
			
			while (!queue.isEmpty()) {
				Cell curr = queue.pop();
				
				if (!maze[curr.row][curr.col].equals("*")) {
					maze[curr.row][curr.col] = String.valueOf(curr.steps);
				}
				
				// go up
				if (curr.col - 1 >= 0 && maze[curr.row][curr.col - 1].equals("0")) {
					queue.add(new Cell(curr.row, curr.col - 1, curr.steps + 1));
				}
				
				// go down
				if (curr.col + 1 < length && maze[curr.row][curr.col + 1].equals("0")) {
					queue.add(new Cell(curr.row, curr.col + 1, curr.steps + 1));
				}
				
				// go left
				if (curr.row - 1 >= 0 && maze[curr.row - 1][curr.col ].equals("0")) {
					queue.add(new Cell(curr.row - 1, curr.col, curr.steps + 1));
				}
				
				// go right
				if (curr.row + 1 < length && maze[curr.row + 1][curr.col].equals("0")) {
					queue.add(new Cell(curr.row + 1, curr.col, curr.steps + 1));
				}
			}
			
			// print
			for (int row = 0; row < length; row++) {
				for (int col = 0; col < length; col++) {
					if (maze[row][col].equals("0")) {
						System.out.print("u");
					} else {
						System.out.print(maze[row][col]);
					}
				}
				
				System.out.println();
			}
		}
	}
}

class Cell {
	public int row;
	public int col;
	public int steps;
	
	public Cell(int row, int col, int steps) {
		this.row = row;
		this.col = col;
		this.steps = steps;
	}
}