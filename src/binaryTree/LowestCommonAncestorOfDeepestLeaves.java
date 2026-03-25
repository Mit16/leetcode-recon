package binaryTree;

import java.util.*;

import binaryTree.BinaryTree.TreeNode;
import binaryTree.SmallestSubTree.Result;

class LCAofDeepestLeaves {
	class Result {
		private int depth;
		private TreeNode node;

		public Result(int depth, TreeNode node) {
			// TODO Auto-generated constructor stub
			this.depth = depth;
			this.node = node;
		}
	}

	public TreeNode lowestCommonAncestorDeepestleaves(TreeNode root) {
		return dfsResult(root).node;
	}

	private Result dfsResult(TreeNode root) {
		if (root == null) {
			return new Result(0, null);
		}

		Result left = dfsResult(root.left);
		Result right = dfsResult(root.right);

		if (left.depth > right.depth) {
			return new Result(left.depth + 1, left.node);
		}
		if (right.depth > left.depth) {
			return new Result(right.depth + 1, right.node);
		}

		return new Result(left.depth + 1, root);

	}
}

public class LowestCommonAncestorOfDeepestLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		Integer[] nums = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		tree.buildTree(nums);

		System.out.println("--- Tree Structure ---");
		tree.prettyDisplay();

		LCAofDeepestLeaves solver = new LCAofDeepestLeaves();
		TreeNode result = solver.lowestCommonAncestorDeepestleaves(tree.getRoot());

		if (result != null) {
			System.out.println("Result (Root of smallest subtree): " + result.val);
		} else {
			System.out.println("Result is null");
		}
		System.out.print("--END--");
	}

}
