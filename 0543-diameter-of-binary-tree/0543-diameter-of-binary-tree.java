/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max-1;
    }

    private int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int left = 1 + diameter(root.left);
        int right = 1 + diameter(root.right);

        int currMax = right + left - 1;
        max = Math.max(currMax,max);

        return Math.max(left, right);
    }
}