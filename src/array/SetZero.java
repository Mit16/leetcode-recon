package array;

import java.util.*;

// Renamed 'Soultion' to 'Solution' for clarity
class Setzero {

	// Brute force approch
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < row; k++) {
						if (matrix[k][j] != 0)
							matrix[k][j] = -1;
					}

					for (int k = 0; k < col; k++) {
						if (matrix[i][k] != 0) {
							matrix[i][k] = -1;
						}
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// Better Approch
	public void setZeroes1(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[] setRow = new boolean[row];
		boolean[] setCol = new boolean[col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					setRow[i] = true;
					setCol[j] = true;
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (setRow[i] || setCol[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// Optimal Approch
	public void setZeroes2(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		boolean firstRowFlag = false;
		boolean firstColFlag = false;

		for (int j = 0; j < col; j++) {
			if (matrix[0][j] == 0) {
				firstRowFlag = true;
				break;
			}
		}
		
		for(int i=0;i<row;i++) {
			if(matrix[i][0]==0){
				firstColFlag=true;
				break;
			}
		}
		
		for(int i=1;i<row;i++) {
			for(int j= 1;j<col;j++) {
				if(matrix[i][j]==0) {
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		
		for(int i=1;i<row;i++) {
			for(int j= 1;j<col;j++) {
				if(matrix[0][j]==0 || matrix[i][0]==0) {
					matrix[i][j]=0;
				}
			}
		}
		
		if(firstRowFlag) {
			for(int j=0;j<col;j++) {
				matrix[0][j]=0;
			}
		}
		
		if(firstColFlag) {
			for(int i=0;i<row;i++) {
				matrix[i][0]=0;
			}
		}
		
		
	}
}

// Renamed to match file 'SetMatrix.java'
public class SetZero {
	public static void main(String[] args) {
		int[][] matrix = { { 0,1,2,0 }, { 3,4,5,2 }, { 1,3,1,5 } };
		
		// Fixed spelling here
		Setzero sol = new Setzero();
//		sol.setZeroes(matrix);
		sol.setZeroes2(matrix);

		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}