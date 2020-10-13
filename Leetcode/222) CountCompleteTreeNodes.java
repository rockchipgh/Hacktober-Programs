/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    public int countNodes(TreeNode root) {
        inorder(root);
        return count;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        count+=1;
        inorder(root.right);
    }
}