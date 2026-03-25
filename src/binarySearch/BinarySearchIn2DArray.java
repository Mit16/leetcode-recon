package binarySearch;

import java.util.Arrays;

class RowColMatrix {

	// 1st approch
	/*
	 * Short Answer: It doesn't fail to find the answer. It fails to be fast enough.
	 * Code 1 (Staircase Search): It starts at the top-right corner. It moves Left
	 * or Down. - This algorithm ignores the fact that the entire matrix is sorted
	 * (like a single long list). It treats it row-by-row. - Time Complexity: O(N +
	 * M)(Linear). If you have a 1000 * 1000 matrix, it might take 2000 steps.
	 */
	public int[] searchO(int[][] matrix, int target) {
		int row = 0;
		int col = matrix.length - 1;

		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}

		return new int[] { -1, -1 };
	}

	// 2nd Approch
	/*
	 * Code 2 (Strictly Sorted Binary Search): It treats the matrix as a true
	 * strictly sorted sequence.
	 * 
	 * Time Complexity: O(log(N.M)) (Logarithmic). If you have a 1000 * 1000 matrix,
	 * it takes only ~20 steps.
	 */
	public int[] search(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length; // be cautious, matrix may be empty.

		if (rows == 1) {
			return binarySearch(matrix, 0, 0, cols - 1, target);
		}

		int rStart = 0;
		int rEnd = rows - 1;
		int cMid = cols / 2;

		// Loop runs until only 2 rows are remaining
		while (rStart < (rEnd - 1)) {
			int mid = rStart + (rEnd - rStart) / 2;

			if (matrix[mid][cMid] == target) {
				return new int[] { mid, cMid };
			}
			if (matrix[mid][cMid] < target) {
				rStart = mid;
			} else {
				rEnd = mid;
			}
		}

		// Now we have two rows left (rStart and rStart + 1)
		// Check if the target is in the middle column of these two rows
		if (matrix[rStart][cMid] == target) {
			return new int[] { rStart, cMid };
		}
		if (matrix[rStart + 1][cMid] == target) {
			return new int[] { rStart + 1, cMid };
		}

		// Search in 1st half (Top-Left)
		if (target <= matrix[rStart][cMid - 1]) {
			return binarySearch(matrix, rStart, 0, cMid - 1, target);
		}
		// Search in 2nd half (Top-Right)
		if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
			return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
		}
		// Search in 3rd half (Bottom-Left)
		if (target <= matrix[rStart + 1][cMid - 1]) {
			return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
		}
		// Search in 4th half (Bottom-Right)
		else {
			return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
		}
	}

	// Binary Search in a specific row between colStart and colEnd
	private int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
		while (cStart <= cEnd) {
			int mid = cStart + (cEnd - cStart) / 2;

			if (matrix[row][mid] == target) {
				return new int[] { row, mid };
			} else if (matrix[row][mid] < target) {
				cStart = mid + 1;
			} else {
				cEnd = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}

}

public class BinarySearchIn2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {
//				{10,20,30,40},
//				{15,25,35,45},
//				{28,29,37,49},
//				{33,34,38,50}
//		};
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int target = 10;
		RowColMatrix solver = new RowColMatrix();
		System.out.println("---START---");
//		int[] result = solver.searchO(matrix, target);
		int[] result = solver.search(matrix, target);
		System.out.println(Arrays.toString(result));
		System.out.println(result[0] != -1 ? matrix[result[0]][result[1]] : "Not Exists");
		System.out.println("---END---");
	}

}
