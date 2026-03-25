package array;

import java.util.*;

class LargestSquareAreaSolution {
	public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
		// Write your solution here
		// 1. Loop through all pairs (i, j)
		// 2. Find the intersection rectangle between rectangle i and rectangle j
		// 3. Calculate the maximum square side that fits in that intersection
		// 4. Keep track of the max side found so far
		long maxSide = 0;
		int n = bottomLeft.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
				long maxX = Math.min(topRight[i][0], topRight[j][0]);

				long minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
				long maxY = Math.min(topRight[i][1], topRight[j][1]);

				long width = maxX - minX;
				long height = maxY - minY;

				if (width > 0 && height > 0) {
					long side = Math.min(width, height);
					maxSide = Math.max(maxSide, side);
				}
			}
		}

		return maxSide * maxSide;
	}
}

public class LargestSquareArea {

	public static void main(String[] args) {
		LargestSquareAreaSolution solver = new LargestSquareAreaSolution();

		// --- Example 1 ---
		// Output: 1
		int[][] bl1 = { { 1, 1 }, { 2, 2 }, { 3, 1 } };
		int[][] tr1 = { { 3, 3 }, { 4, 4 }, { 6, 6 } };
		System.out.println("--- Test Case 1 ---");
		System.out.println("Result: " + solver.largestSquareArea(bl1, tr1));

		// --- Example 2 ---
		// Output: 4
		int[][] bl2 = { { 1, 1 }, { 1, 3 }, { 1, 5 } };
		int[][] tr2 = { { 5, 5 }, { 5, 7 }, { 5, 9 } };
		System.out.println("\n--- Test Case 2 ---");
		System.out.println("Result: " + solver.largestSquareArea(bl2, tr2));

		// --- Example 3 ---
		// Output: 1
		int[][] bl3 = { { 1, 1 }, { 2, 2 }, { 1, 2 } };
		int[][] tr3 = { { 3, 3 }, { 4, 4 }, { 3, 4 } };
		System.out.println("\n--- Test Case 3 ---");
		System.out.println("Result: " + solver.largestSquareArea(bl3, tr3));

		// --- Example 4 ---
		// Output: 0
		int[][] bl4 = { { 1, 1 }, { 3, 3 }, { 3, 1 } };
		int[][] tr4 = { { 2, 2 }, { 4, 4 }, { 4, 2 } };
		System.out.println("\n--- Test Case 4 ---");
		System.out.println("Result: " + solver.largestSquareArea(bl4, tr4));
	}
}