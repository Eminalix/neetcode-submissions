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
    List<Integer> list = new ArrayList<>();

    public void DFS(TreeNode root, int depth) {
        if(root == null) return ;

        if(list.size() < depth) list.add(root.val);

        if(root.right != null) {
            DFS(root.right, depth + 1);
            DFS(root.left, depth + 1);
        }
        else if(root.left != null) {
            DFS(root.left, depth + 1);
            DFS(root.right, depth + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return list;

        DFS(root, 1);

        return list;
    }
}
