package binaryTree;

import binaryTree.BinaryTree.TreeNode;

public class MaxProductSplittedBinaryTree {

    long totalTreeSum = 0;
    long maxProductResult = 0;

    // --- LEETCODE SOLUTION ---
    public int maxProduct(TreeNode root) {
        totalTreeSum = 0;
        maxProductResult = 0;

        totalSum(root);
        getSubtreeSum(root);

        return (int) (maxProductResult % 1_000_000_007);
    }

    private void totalSum(TreeNode root) {
        if (root == null) return;
        totalTreeSum += root.val;
        totalSum(root.left);
        totalSum(root.right);
    }

    private long getSubtreeSum(TreeNode root) {
        if (root == null) return 0;
        
        long left = getSubtreeSum(root.left);
        long right = getSubtreeSum(root.right);

        long currentSubtreeSum = root.val + left + right;
        long currentProduct = (totalTreeSum - currentSubtreeSum) * currentSubtreeSum;
        
        if (currentProduct > maxProductResult) {
            maxProductResult = currentProduct;
        }
        return currentSubtreeSum;
    }

    // --- RUNNER ---
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer[] nums = { 1, 2, 3, 4, 5, 6 };
        tree.buildTree(nums);

        System.out.println("--- Tree Structure ---");
        tree.prettyDisplay();

        MaxProductSplittedBinaryTree solver = new MaxProductSplittedBinaryTree();
        System.out.println("Max Product: " + solver.maxProduct(tree.getRoot()));
    }
}