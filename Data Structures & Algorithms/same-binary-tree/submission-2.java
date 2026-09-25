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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;
        
        Stack<TreeNode> pq = new Stack<>();
        Stack<TreeNode> qq = new Stack<>();
        pq.push(p);
        qq.push(q);

        while(!pq.isEmpty() && !qq.isEmpty()) {
            p = pq.pop();
            q = qq.pop();

            if(p == null && q != null) return false;
            if(q == null && p != null) return false;
            if(p != null && q != null) {
                if(p.val != q.val) return false;
                pq.push(p.left);
                pq.push(p.right);
                qq.push(q.left);
                qq.push(q.right);
            }
        }

        return true;
    }
}
