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
    int res = 0;
    int cnt = 0;

    public void DFS(TreeNode root, int k) {
        if(root == null) return ;

        DFS(root.left, k);
        cnt++;
        if(cnt == k) {
            res = root.val;
            return ;
        }
        
        DFS(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        DFS(root, k);
        return res;
    }
}
