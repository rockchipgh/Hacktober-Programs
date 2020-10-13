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
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }
    public void mirror(TreeNode root){
        if(root==null)
            return;
        // swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // now, recursively swap on left and right subtrees
        mirror(root.left);
        mirror(root.right);
    }
}