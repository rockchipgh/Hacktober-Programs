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
    List<Integer> nodes = new ArrayList<Integer>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(nodes);
        return nodes;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
}