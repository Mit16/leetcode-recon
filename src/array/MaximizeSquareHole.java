package array;

import java.util.Arrays;

class MaximizeSquareHoleSolution {
	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
		// Write your solution here
		// 1. Sort the bars to easily find consecutive sequences
		// 2. Find the max consecutive horizontal bars
		// 3. Find the max consecutive vertical bars
		// 4. Determine the side of the square

		Arrays.sort(vBars);
		Arrays.sort(hBars);
		
		int maxConsecutiveHBars = 1;
		int maxConsecutiveVBars = 1;
		
		int currConsecutiveBars = 1;
		for(int i = 1;i<=hBars.length-1;i++) {
			if(hBars[i]-hBars[i-1]==1) {
				currConsecutiveBars++;
			}else {
				currConsecutiveBars=1;
			}
			maxConsecutiveHBars = Math.max(maxConsecutiveHBars,currConsecutiveBars);
		}
		
		currConsecutiveBars=1;
		for(int i = 1;i<=vBars.length-1;i++) {
			if(vBars[i]-vBars[i-1]==1) {
				currConsecutiveBars++;
			}else {
				currConsecutiveBars=1;
			}
			maxConsecutiveVBars = Math.max(maxConsecutiveVBars,currConsecutiveBars);
		}
		
		int maxSquare = Math.min(maxConsecutiveHBars,maxConsecutiveVBars)+1;
		
		return maxSquare*maxSquare;
	}
}

public class MaximizeSquareHole {

	public static void main(String[] args) {
		MaximizeSquareHoleSolution solver = new MaximizeSquareHoleSolution();

		// --- Example 1 ---
		// Input: n = 2, m = 1, hBars = [2,3], vBars = [2]
		// Output: 4
		int n1 = 2;
		int m1 = 1;
		int[] hBars1 = { 2, 3 };
		int[] vBars1 = { 2 };
		System.out.println("--- Test Case 1 ---");
		System.out.println("Result: " + solver.maximizeSquareHoleArea(n1, m1, hBars1, vBars1));

		// --- Example 2 ---
		// Input: n = 1, m = 1, hBars = [2], vBars = [2]
		// Output: 4
		int n2 = 1;
		int m2 = 1;
		int[] hBars2 = { 2 };
		int[] vBars2 = { 2 };
		System.out.println("\n--- Test Case 2 ---");
		System.out.println("Result: " + solver.maximizeSquareHoleArea(n2, m2, hBars2, vBars2));

		// --- Example 3 ---
		// Input: n = 2, m = 3, hBars = [2,3], vBars = [2,4]
		// Output: 4
		int n3 = 2;
		int m3 = 3;
		int[] hBars3 = { 2, 3 };
		int[] vBars3 = { 2, 4 };
		System.out.println("\n--- Test Case 3 ---");
		System.out.println("Result: " + solver.maximizeSquareHoleArea(n3, m3, hBars3, vBars3));
	}
}