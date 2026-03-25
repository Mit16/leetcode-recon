package binaryTree;

import java.util.*;

public class BinaryTree {

    private TreeNode root;

    // --- NODE CLASS (Public so other files can see it) ---
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // --- GETTER (Essential for Solution files) ---
    public TreeNode getRoot() {
        return this.root;
    }

    // --- HELPER: Find a node object by value ---
    // (Used to simulate "finding" a node p or q in a tree)
    public TreeNode findNode(int val) {
        return findNodeRecursive(this.root, val);
    }

    private TreeNode findNodeRecursive(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        
        TreeNode left = findNodeRecursive(node.left, val);
        if (left != null) return left;
        
        return findNodeRecursive(node.right, val);
    }

    // --- BUILDER: LeetCode Style Array ---
    public void buildTree(Integer[] data) {
        if (data == null || data.length == 0) return;

        this.root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);

        int i = 1;
        while (i < data.length) {
            TreeNode current = queue.poll();
            
            // Left Child
            if (i < data.length && data[i] != null) {
                current.left = new TreeNode(data[i]);
                queue.add(current.left);
            }
            i++;
            
            // Right Child
            if (i < data.length && data[i] != null) {
                current.right = new TreeNode(data[i]);
                queue.add(current.right);
            }
            i++;
        }
    }

    // --- DISPLAY ---
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(TreeNode node, int level) {
        if (node == null) return;
        prettyDisplay(node.right, level + 1);
        
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) System.out.print("|\t\t");
            System.out.println("|--->" + node.val);
        } else {
            System.out.println(node.val);
        }
        
        prettyDisplay(node.left, level + 1);
    }
}	