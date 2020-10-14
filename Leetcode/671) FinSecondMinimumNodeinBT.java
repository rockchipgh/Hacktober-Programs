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
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
    Set<Integer> uniqueAlreadyAdded = new HashSet<>();
    
    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        if(priorityQueue.size() <=1) {
            return -1;
        }
        
        else {
            priorityQueue.poll();
            return priorityQueue.poll();
        }
    }
    
    public void traverse(TreeNode node) {
        if(node == null) {
            return;
        }
        
       if(!uniqueAlreadyAdded.contains(node.val)) {
         uniqueAlreadyAdded.add(node.val);  
         priorityQueue.add(node.val);
       }
         traverse(node.left);
         traverse(node.right);
    }
}