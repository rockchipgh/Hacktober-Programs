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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        return calcDiameter(root);
    }
    public int calcDiameter(TreeNode root){
        if(root==null)
            return 0;
       
        int l = calcHeight(root.left);
        int r = calcHeight(root.right);
        return Math.max(l+r,Math.max(calcDiameter(root.left),calcDiameter(root.right)));
    }
    public int calcHeight(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
    }
}