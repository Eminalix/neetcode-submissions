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
    public record Pair(int height, int diameter) {}

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Map<TreeNode, Pair> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;

        stack.push(root);
        map.put(null, new Pair(0, 0));

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if(node.left != null &&
            !map.containsKey(node.left)) {
                stack.push(node.left);
            }
            else if(node.right != null &&
            !map.containsKey(node.right)) {
                stack.push(node.right);
            }
            else {
                node = stack.pop();
                Pair left = map.get(node.left);
                Pair right = map.get(node.right);

                int lh = left.height;
                int ldiam = left.diameter;
                int rh = right.height;
                int rdiam = right.diameter;

                int height = 1 + Math.max(lh, rh);
                int diameter = Math.max(lh + rh, Math.max(ldiam, rdiam));

                map.put(node, new Pair(height, diameter));
            }
        }

        return map.get(root).diameter;
    }
}
/*
    diameter = maxDepth(left subtree) + maxDepth(right subtree);
    but i need to consider this such diameter from all nodes
    and decide which is biggest
*/