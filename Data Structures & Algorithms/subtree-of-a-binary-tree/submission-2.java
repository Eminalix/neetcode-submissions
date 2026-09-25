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
    public void DFS(TreeNode root, StringBuilder list) {
        if(root == null) {
            list.append("#null,");
            return ;
        }

        list.append("#" + root.val + ",");
        DFS(root.left, list);
        DFS(root.right, list);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null) return false;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        DFS(root, s1);
        DFS(subRoot, s2);

        return s1.toString().contains(s2.toString());
    }
}
