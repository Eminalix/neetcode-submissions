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
    public int DFS(TreeNode root, int depth) {
        if(root == null) return depth;

        return 1 + Math.max(DFS(root.left, depth), DFS(root.right, depth));
    }

    public int maxDepth(TreeNode root) {
        return DFS(root, 0);
    }
}
