package backtracking;

import java.util.ArrayList;

public class MazeSolving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print(count(4, 4));
//		mazePath("", 3, 3);
//		System.out.println(mazePathRet("", 3, 3));
//		System.out.println(mazePathRetDiagonal("", 3, 3));

		boolean[][] board = { { true, true, true }, { true, false, true }, { true, true, true } };
		mazePathRestrictions("", board, 0, 0);
	}

	static int count(int r, int c) {
		if (r == 1 || c == 1) {
			return 1;
		}

		int left = count(r - 1, c);
		int right = count(r, c - 1);

		return left + right;
	}

	static void mazePath(String p, int r, int c) {
		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}

		if (r > 1) {
			mazePath(p + 'D', r - 1, c);
		}

		if (c > 1) {
			mazePath(p + 'R', r, c - 1);
		}

	}

	static ArrayList<String> mazePathRet(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		if (r > 1) {
			list.addAll(mazePathRet(p + 'D', r - 1, c));
		}

		if (c > 1) {
			list.addAll(mazePathRet(p + 'R', r, c - 1));
		}

		return list;
	}

	static ArrayList<String> mazePathRetDiagonal(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();

		if (r > 1 && c > 1) {
			list.addAll(mazePathRetDiagonal(p + 'D', r - 1, c - 1));
		}

		if (r > 1) {
			list.addAll(mazePathRetDiagonal(p + 'V', r - 1, c));
		}

		if (c > 1) {
			list.addAll(mazePathRetDiagonal(p + 'H', r, c - 1));
		}

		return list;
	}

	static void mazePathRestrictions(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		if (!maze[r][c])
			return;

		if (r < maze.length - 1) {
			mazePathRestrictions(p + 'D', maze, r + 1, c);
		}

		if (c < maze[0].length - 1) {
			mazePathRestrictions(p + 'R', maze, r, c + 1);
		}

	}

}
