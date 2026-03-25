package binarySearch;

import java.util.*;

class SeparateSquaresSolutionII {
	public double separateSquares(int[][] squares) {
		// Write your solution here
		// Tip: The total area is constant. You need a 'y' where
		// Area_Below(y) == Total_Area / 2.

		return 0.0;
	}
}

public class SeparateSquaresII {

	public static void main(String[] args) {
		SeparateSquaresSolutionII solver = new SeparateSquaresSolutionII();

		// --- Example 1 ---
		// Input: squares = [[0,0,1],[2,2,1]]
		// Expected Output: 1.00000
		int[][] squares1 = { { 0, 0, 1 }, { 2, 2, 1 } };
		System.out.println("--- Test Case 1 ---");
		double result1 = solver.separateSquares(squares1);
		System.out.printf("Output: %.5f\n", result1);

		// --- Example 2 ---
		// Input: squares = [[0,0,2],[1,1,1]]
		// Expected Output: 1.16667
		int[][] squares2 = { { 0, 0, 2 }, { 1, 1, 1 } };
		System.out.println("\n--- Test Case 2 ---");
		double result2 = solver.separateSquares(squares2);
		System.out.printf("Output: %.5f\n", result2);
	}
}