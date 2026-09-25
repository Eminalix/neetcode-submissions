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
    int max = 0;

    public int DFS(TreeNode root) {
        if(root == null) return 0;

        int d = DFS(root.left) + DFS(root.right);
        max = Math.max(max, d);

        return 1 + Math.max(DFS(root.left), DFS(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return max;
    }
}
/*
    diameter = maxDepth(left subtree) + maxDepth(right subtree);
    but i need to consider this such diameter from all nodes
    and decide which is biggest
*/