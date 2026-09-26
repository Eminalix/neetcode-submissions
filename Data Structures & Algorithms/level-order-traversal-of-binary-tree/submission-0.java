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
        Map<TreeNode, Integer> map = new HashMap<>();

        Q.add(root);
        map.put(root, 1);

        while(!Q.isEmpty()) {
            TreeNode node = Q.poll();
            int lvl = map.get(node);

            if(res.size() < lvl) {
                res.add(new ArrayList<>());
            }

            res.get(lvl - 1).add(node.val);

            if(node.left != null) {
                map.put(node.left, lvl + 1);
                Q.add(node.left);
            }

            if(node.right != null) {
                map.put(node.right, lvl + 1);
                Q.add(node.right);
            }
        }

        return res;

    }
}
