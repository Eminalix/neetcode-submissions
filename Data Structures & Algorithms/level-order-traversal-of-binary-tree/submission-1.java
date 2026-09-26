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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> Q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        Q.add(root);

        while(!Q.isEmpty()) {
            int cnt = Q.size();
            List<Integer> list = new ArrayList<>();

            while(cnt != 0) {
                TreeNode node = Q.poll();
                list.add(node.val);
                cnt--;

                if(node.left != null) {
                    Q.add(node.left);
                }

                if(node.right != null) {
                    Q.add(node.right);
                }
            }

            res.add(list);
        }

        return res;

    }
}
