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
    List<Integer> list = new ArrayList<Integer>();
    HashSet<Integer> set = new HashSet<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return list;
        view(root, 0);
        return list;
    }
    public void view(TreeNode root, int depth){
        if(root==null)
            return;
        
        if(!set.contains(depth)){
            list.add(root.val);
            set.add(depth);    
        }
        view(root.right, depth+1);
        view(root.left, depth+1);
    }
}