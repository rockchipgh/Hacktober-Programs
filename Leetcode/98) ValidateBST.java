class Solution {
    List<Integer> list = new ArrayList();    
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        if(list.size()==0)
            return true;
        int prev = list.get(0);
        for(int i=1; i<list.size(); i++){
            int curr = list.get(i);
            if(prev>=curr)
                return false;
            prev = curr;
        }
        return true;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}