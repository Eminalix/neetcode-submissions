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
    Map<Integer, Integer> map = new HashMap<>(); // el + poz
    TreeNode root;
    int p = 0;

    public TreeNode BST(int[] preorder, int st, int dr) {
        if(st > dr) return null;

        int mij = map.get(preorder[p]);
        TreeNode root = new TreeNode(preorder[p]);
        ++p;
        
        root.left = BST(preorder, st, mij - 1);
        root.right = BST(preorder, mij + 1, dr);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        
        return BST(preorder, 0, inorder.length - 1);
        
    }
}
/*
    so in preorder the order is RSD so radacina stanga dreapta
    so the first node is the root
    and in inorder its SRD so left root right
    so the root node is somewhere in the middle
    and it splits the tree into the left part to the left of it
    and right subtree to the right of it
    so after figuring out where the root is
    we use divide and conquer
    and we say that root.left = and we evaluate the same thing 
    for the array to the left of the root in the inorder
    and root.right = evaluation of the same subprogram
    but for the array to the right of the root of the inorder array
    and ofc the next root will be the next index of the preorder array

    Preorder = Root → Left → Right, so preorder[0] (or whatever index you're currently 
    at) is always the root of the current subtree.
    Inorder = Left → Root → Right, so once you find that root's value inside the inorder 
    array, everything to its left is the entire left subtree (inorder), and everything to 
    its right is the entire right subtree (inorder).
    Recursively: root.left = build the tree from (that left inorder slice) + (the 
    corresponding preorder slice), and root.right = build the tree from (the right 
    inorder slice) + (corresponding preorder slice).
    The next value to consume from preorder is always "the next unused preorder element," 
    which becomes the root of whichever subtree you build next.
    If you use a HashMap<Integer, Integer> mapping value → index in inorder, built once 
    upfront
*/