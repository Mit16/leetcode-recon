package array;

import java.util.Arrays;

class MaxSideLengthSquareSolution {
	// optimise approch
	public int maxSideLength(int[][] mat, int threshold) {
		// Write your solution here
		// 1. Build the 2D Prefix Sum array (be careful with 1-based indexing for
		// convenience)
		// 2. Binary Search for the side length (low = 0, high = min(m, n))
		// 3. Helper function: boolean isValid(int k, int threshold, prefixSum)

		int row = mat.length;
		int col = mat[0].length;

		int[][] prefixSum = new int[row + 1][col + 1];

		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i-1][j-1] + mat[i - 1][j - 1];
			}
		}
		
		int bestSide = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				for(int k=0;k<Math.min(row-1,col-1);k++) {
					int r2 = i+k;
					int c2= j+k;
					int sum = sumSquare(i,j,r2,c2,prefixSum);
					if(sum<=threshold) {
						bestSide = Math.max(bestSide,k+1);
					}else {
						break;
					}
				}
			}
		}

		return bestSide;
	}
	
	private int sumSquare(int i,int j,int r2,int c2,int[][] prefixSum) {
		int sum = prefixSum[r2+1][c2+1]-prefixSum[i][c2+1]-prefixSum[j][r2+1]+prefixSum[i][j];
		return sum;
	}

	// Brute force approch
//    public int maxSideLength(int[][] mat,int threshold) {
//    	int bestSqSide = 0;
//    	int rows = mat.length;
//    	int cols = mat[0].length;
//    	
//    	for(int i=0;i<rows;i++) {
//    		for(int j=0;j<cols;j++) {
//    			for(int k =0;i+k-1<rows && j+k-1<cols;k++) {
//    				int val = findSum(mat,i,j,k);
//    				if(val<=threshold) {
//    					bestSqSide=Math.max(bestSqSide,k);
//    				}else {
//    					break;
//    				}
//    			}
//    		}
//    	}
//    	
//    	return bestSqSide;
//    }
//    
//    private int findSum(int[][] mat,int r,int c,int k) {
//    	int totalSum = 0;
//    	for(int x=0;x<k;x++) {
//    		for(int y = 0;y<k;y++) {
//    			totalSum+=mat[r+x][c+y];
//    		}
//    	}
//    	
//    	return totalSum;
//    }
}

public class MaxSideLengthSquare {

	public static void main(String[] args) {
		MaxSideLengthSquareSolution solver = new MaxSideLengthSquareSolution();

		// --- Example 1 ---
		// Output: 2
		int[][] mat1 = { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } };
		int threshold1 = 4;
		System.out.println("--- Test Case 1 ---");
		System.out.println("Result: " + solver.maxSideLength(mat1, threshold1));

		// --- Example 2 ---
		// Output: 0
		int[][] mat2 = { { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 },
				{ 2, 2, 2, 2, 2 } };
		int threshold2 = 1;
		System.out.println("\n--- Test Case 2 ---");
		System.out.println("Result: " + solver.maxSideLength(mat2, threshold2));
	}
}