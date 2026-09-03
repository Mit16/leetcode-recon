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
    public boolean isBalanced(TreeNode root) {
        if (root == null ) return true;

        int left = checkHeight(root.left);
        int right = checkHeight(root.right);

        if(Math.abs(left-right)>2) return false;

        return isBalanced(root.left) && isBalanced(root.right);

       
    }

    private int checkHeight(TreeNode root){
        if (root == null) return 0;

        int left = 1 + checkHeight(root.left);
        int right = 1+ checkHeight(root.right);

        return Math.max(left,right)+1;
    }
}