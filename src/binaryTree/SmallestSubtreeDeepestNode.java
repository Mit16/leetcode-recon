package binaryTree;

import java.util.HashMap;
import binaryTree.BinaryTree.TreeNode;

class SmallestSubTree {

	// 1st Approch
	HashMap<Integer, Integer> mp = new HashMap<>();
	int maxDepth = 0;

	public TreeNode smallestSubtreeDeepestNode(TreeNode root) {

		if (root == null || mp.get(root.val) == maxDepth) {
			return root;
		}

		TreeNode left = smallestSubtreeDeepestNode(root.left);
		TreeNode right = smallestSubtreeDeepestNode(root.right);

		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		return right;

	}

	public void dfs(TreeNode root, int level) {
		if (root == null)
			return;
		maxDepth = Math.max(maxDepth, level);
		mp.put(root.val, level);
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}

	// 2nd Approch
	class Result {
		private int depth;
		private TreeNode node;

		public Result(int depth, TreeNode node) {
			// TODO Auto-generated constructor stub
			this.depth = depth;
			this.node = node;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
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

public class SmallestSubtreeDeepestNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		Integer[] nums = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };

		System.out.println("---Tree being build---");
		tree.buildTree(nums);

		System.out.println("---Tree being displayed---");
		tree.prettyDisplay();

		SmallestSubTree solver = new SmallestSubTree();

		// 1st Approch
//		solver.dfs(tree.getRoot(), 0);
//		TreeNode result = solver.smallestSubtreeDeepestNode(tree.getRoot());

		// 2nd Approch
		TreeNode result = solver.subtreeWithAllDeepest(tree.getRoot());

		if (result != null) {
			System.out.println("Result (Root of smallest subtree): " + result.val);
		} else {
			System.out.println("Result is null");
		}
		System.out.print("--END--");
	}

}
