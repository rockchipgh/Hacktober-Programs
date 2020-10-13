class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if(root==null)
            return root;
        queue.add(null);
        queue.add(root);
        while(queue.size()!=0){
            Node node = queue.poll();
            if(node==null){
                if(queue.size()==0)
                    break;
                Node n = queue.peek();
                n.next = null;
                queue.add(null);
            }else{
                node.next = queue.peek();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return root;
    }
}