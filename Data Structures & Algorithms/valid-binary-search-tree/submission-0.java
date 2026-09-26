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
    public boolean DFS(TreeNode root, int min, int max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return DFS(root.left, min, root.val) && DFS(root.right, root.val, max); 
    }

    public boolean isValidBST(TreeNode root) {
        return DFS(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
