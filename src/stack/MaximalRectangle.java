package stack;

import java.util.Stack;

class MaximalRectangleSolution { // Renamed slightly to avoid confusion
	public int maximalRectangle(char[][] matrix) {
		// Write your solution here
		int m = matrix.length;
		int n = matrix[0].length;

		int[] height = new int[n];
		// Add the first row in the height - 1D
		for (int j = 0; j < n; j++) {
			height[j] = (matrix[0][j] == '1') ? 1 : 0;
		}

		int maxArea = findMaxArea(height);

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (matrix[row][col] == '0') {
					height[col] = 0;
				} else {
					height[col] += 1;
				}
			}

			maxArea = Math.max(maxArea, findMaxArea(height));
		}

		return maxArea;
	}

	private int findMaxArea(int[] height) {
		// height - height[i
		// width - NSR[i] - NSL[i] - 1
		int[] NSR = getNSR(height);
		int[] NSL = getNSL(height);

		int n = height.length;

		int[] width = new int[n];
		for (int i = 0; i < n; i++) {
			width[i] = NSR[i] - NSL[i] - 1;
		}
		
		int maxArea = 0;
		
		for(int i= 0;i<n;i++) {
			int a = width[i] * height[i];
			maxArea = Math.max(maxArea,a);
		}

		return maxArea;
	}

	private int[] getNSR(int[] height) {
		Stack<Integer> st = new Stack<>();

		int n = height.length;
		int[] NSR = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				NSR[i] = n; // out of bound index
			} else {
				while (!st.isEmpty() && height[st.peek()] >= height[i]) {
					st.pop();
				}

				if (st.isEmpty()) {
					NSR[i] = n; // out of bound index
				} else {
					NSR[i] = st.peek();
				}
			}

			st.push(i);
		}

		return NSR;

	}

	private int[] getNSL(int[] heigth) {
		Stack<Integer> st = new Stack<>();

		int n = heigth.length;
		int[] NSL = new int[n];

		for (int i = 0; i < n; i++) {
			if (st.isEmpty()) {
				NSL[i] = -1; // out of bound index
			} else {
				while (!st.isEmpty() && heigth[st.peek()] >= heigth[i]) {
					st.pop();
				}

				if (st.isEmpty()) {
					NSL[i] = -1; // out of bound index
				} else {
					NSL[i] = st.peek();
				}
			}

			st.push(i);
		}

		return NSL;
	}
}

public class MaximalRectangle {

	public static void main(String[] args) {
		// FIX: Use single quotes ' ' for characters, not double quotes " "
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		MaximalRectangleSolution solver = new MaximalRectangleSolution();
		System.out.println("---Start---");
		int result = solver.maximalRectangle(matrix);
		System.out.println(result);
		System.out.print("---END--");
	}
}