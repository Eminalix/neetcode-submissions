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
        
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pq.add(p);
        qq.add(q);

        while(!pq.isEmpty() && !qq.isEmpty()) {
            p = pq.poll();
            q = qq.poll();

            if(p == null && q != null) return false;
            if(q == null && p != null) return false;
            if(p != null && q != null) {
                if(p.val != q.val) return false;
                pq.add(p.left);
                pq.add(p.right);
                qq.add(q.left);
                qq.add(q.right);
            }
        }

        return true;
    }
}
