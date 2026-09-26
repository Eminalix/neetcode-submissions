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
    public int DFS(TreeNode root, int max) {
        if(root == null) return 0;

        if(root.val >= max) return 1 + DFS(root.left, root.val) + DFS(root.right, root.val);

        return DFS(root.left, max) + DFS(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        return DFS(root, root.val);
    }
}
