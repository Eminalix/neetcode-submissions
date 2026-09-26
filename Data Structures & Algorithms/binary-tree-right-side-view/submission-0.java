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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> Q = new ArrayDeque<>();

        if(root == null) return list;

        Q.add(root);

        while(!Q.isEmpty()) {
            int cnt = Q.size();

            for(int i = 0; i < cnt; ++i) {
                TreeNode node = Q.poll();

                if(i == cnt - 1) list.add(node.val);

                if(node.left != null) Q.add(node.left);
                if(node.right != null) Q.add(node.right);
            }
        }

        return list;
    }
}
