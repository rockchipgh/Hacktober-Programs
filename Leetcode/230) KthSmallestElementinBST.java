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
    int smallest = Integer.MIN_VALUE, count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return smallest;
    }
    public void inorder(TreeNode root, int k){
        if(root==null)
            return;
        inorder(root.left, k);
        count+=1;
        if(count==k){
            smallest = root.val;
            return;
        }
        inorder(root.right, k);
    }
}