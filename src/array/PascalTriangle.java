package array;

import java.util.*;

class Pascaltriangle{

	// Approch 1
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
					row.add(val);
				}

			}
			triangle.add(row);
		}

		return triangle;
	}

	// Approch 2
	public List<Long> getNthRow(int N) {
		List<Long> row = new ArrayList<Long>();
		
		long val = 1;
		row.add(val);
		
		for(int k=1;k<N;k++) {
			val = val * (N-k)/k;
			row.add(val);
		}
		
		return row;
	}
}

public class PascalTriangle {

	public static void main(String[] args) {
		Pascaltriangle sol = new Pascaltriangle();
		int numRows = 5;

		// Approch 1
//		List<List<Integer>> pascal = sol.generate(numRows);
//
//		// Print the result
//		for (List<Integer> row : pascal) {
//			for (Integer val : row) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}

		// Approch 2
		List<Long> result = sol.getNthRow(numRows);
		for (long num : result) {
			System.out.print(num + " ");
		}

	}

}
