package array;

import java.util.Arrays;

class LargestMagicSquareSolution {
	public int largestMagicSquare(int[][] grid) {
		// Write your solution here
		// 1. Precompute row and column prefix sums for O(1) sum retrieval.
		// 2. Iterate through possible sizes 'k' from min(m, n) down to 2.
		// 3. For each size, slide the window over the grid.
		// 4. Check if rows, columns, and diagonals sum to the same value.
		// 5. Return the first 'k' that works. If none work > 1, return 1.
		int row = grid.length;
		int col = grid[0].length;
		int[][] rowSum = new int[row][col+1];
		int[][] colSum = new int[row+1][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				rowSum[i][j+1]= rowSum[i][j]+grid[i][j];
				colSum[i+1][j] = colSum[i][j]+grid[i][j];
			}
		}
		
		for(int k= Math.min(row,col);k>=2;k--) {
			for(int i=0;i+k-1<row;i++) {
				for(int j=0;j+k-1<col;j++) {
					if(isMagicSquare(grid,rowSum,colSum,i,j,k)) {
						return k;
					}
				}
			}
		}

		return 1; // Default result (every 1x1 cell is a magic square)
	}
	
	private boolean isMagicSquare(int[][] grid,int[][] rowSum,int[][] colSum,int r,int c,int k) {
		
		int digSum = 0;
		int antiDigSum = 0;
		
		for(int x=0;x<k;x++) {
			digSum += grid[r+x][c+x];
			antiDigSum += grid[r+x][c+k-1-x];
		}
		
		if(digSum!=antiDigSum) {
			return false;	
		}
		
		for(int i=0;i<k;i++) {
			int parseRowSum = rowSum[r+i][c+k]-rowSum[r+i][c];
			if(parseRowSum!=antiDigSum) return false;
		}
		
		for(int j=0;j<k;j++) {
			int parseColSum = colSum[r+k][c+j]-colSum[r][c+j];
			if(parseColSum!=antiDigSum) return false;
		}
		
		return true;
	}
}

public class LargestMagicSquare {

	public static void main(String[] args) {
		LargestMagicSquareSolution solver = new LargestMagicSquareSolution();

		// --- Example 1 ---
		// Output: 3
		int[][] grid1 = { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } };
		System.out.println("--- Test Case 1 ---");
		System.out.println("Result: " + solver.largestMagicSquare(grid1));

		// --- Example 2 ---
		// Output: 2
		int[][] grid2 = { { 5, 1, 3, 1 }, { 9, 3, 3, 1 }, { 1, 3, 3, 8 } };
		System.out.println("\n--- Test Case 2 ---");
		System.out.println("Result: " + solver.largestMagicSquare(grid2));
	}
}