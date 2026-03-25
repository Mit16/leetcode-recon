package binaryTree;

import binaryTree.BinaryTree.TreeNode;

public class LowestCommonAncestor {

    // --- LEETCODE SOLUTION ---
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        if (leftN != null && rightN != null) {
            return root;
        }

        return (leftN != null) ? leftN : rightN;
    }

    // --- RUNNER ---
    public static void main(String[] args) {
        // 1. Setup
        BinaryTree tree = new BinaryTree();
        Integer[] nums = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        tree.buildTree(nums);
        
        System.out.println("--- Tree Structure ---");
        tree.prettyDisplay();

        // 2. Get Inputs
        TreeNode p = tree.findNode(5);
        TreeNode q = tree.findNode(4);

        // 3. Execute
        LowestCommonAncestor solver = new LowestCommonAncestor();
        TreeNode result = solver.lowestCommonAncestor(tree.getRoot(), p, q);

        if (result != null) {
            System.out.println("LCA is: " + result.val);
        } else {
            System.out.println("LCA not found.");
        }
    }
}