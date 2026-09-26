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
    public record Pair(TreeNode node, int max) {}

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> Q = new ArrayDeque<>();
        int cnt = 0;
        Q.add(new Pair(root, root.val));

        while(!Q.isEmpty()) {
            Pair pair = Q.poll();
            TreeNode node = pair.node;
            int max = pair.max;

            if(node.val >= max) {
                cnt++;
                max = node.val;
            }

            if(node.left != null) Q.add(new Pair(node.left, max));
            if(node.right != null) Q.add(new Pair(node.right, max));
        }

        return cnt;
    }
}
