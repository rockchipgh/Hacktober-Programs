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
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathCost(root,sum,0);
    }
    public boolean pathCost(TreeNode root, int sum, int stn){
        if(root==null)
            return false;
        stn+=root.val;
        // Ensuring that the sum is found at the leaf node only....
        if(stn==sum && root.left==null && root.right==null)
            return true;
        
        return (pathCost(root.left,sum,stn) || pathCost(root.right,sum,stn));
    }
}