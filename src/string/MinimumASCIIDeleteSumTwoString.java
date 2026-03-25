package string;

class MinimumASCIIDeleteSum {

	int m, n;
	// FIX 1: Use Integer[][] instead of int[][] so we can check for 'null'.
	// In Java, array size is defined during initialization (new Integer[...]), not
	// declaration.
	Integer[][] t;

	public int minimumDeleteSum(String s1, String s2) {
		m = s1.length();
		n = s2.length();
		// FIX 2: Initialize the array here with the specific string sizes (+1 for
		// boundary)
		t = new Integer[m + 1][n + 1];
		return solve(0, 0, s1, s2);
	}

	private int solve(int i, int j, String s1, String s2) {
		if (i >= m && j >= n) {
			return 0;
		}

		// This check works now because t is Integer[][]
		if (t[i][j] != null) {
			return t[i][j];
		}

		if (i >= m) {
			// FIX 3: Java strings use .charAt(index), not brackets []
			return t[i][j] = s2.charAt(j) + solve(i, j + 1, s1, s2);
		}
		if (j >= n) {
			return t[i][j] = s1.charAt(i) + solve(i + 1, j, s1, s2);
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return t[i][j] = solve(i + 1, j + 1, s1, s2);
		}

		// Java automatically converts char to int (ASCII) during addition
		int delete_s1_i = s1.charAt(i) + solve(i + 1, j, s1, s2);
		int delete_s2_j = s2.charAt(j) + solve(i, j + 1, s1, s2);

		return t[i][j] = Math.min(delete_s1_i, delete_s2_j);
	}

}

public class MinimumASCIIDeleteSumTwoString {

	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";

		MinimumASCIIDeleteSum solver = new MinimumASCIIDeleteSum();

		int result = solver.minimumDeleteSum(s1, s2);
		System.out.println("---START---");
		System.out.println(result); // Expected output: 231
		System.out.println("---END---");
	}

}