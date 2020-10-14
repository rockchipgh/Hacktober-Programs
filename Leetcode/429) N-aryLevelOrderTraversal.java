/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        Queue<Integer> qd = new LinkedList<Integer>();
        Queue<Integer> qdc = new LinkedList<Integer>();
        Vector<Integer> store = new Vector<Integer>();
        if(root==null)
            return result;
        q.add(root);
        qd.add(0);
        qdc.add(0);
        int depth = 0;
        while(!q.isEmpty()){
            root = q.poll();
            depth = qd.poll();
            for(Node n: root.children){
                q.add(n);
                qd.add(depth+1);
                qdc.add(depth+1);
            }
            store.add(root.val);
        }
        depth = 0;
        List<Integer> ls = new ArrayList<Integer>();
        while(!qdc.isEmpty()){
            int curr_depth = qdc.poll();
            if(depth!=curr_depth){
                result.add(ls);
                ls = new ArrayList<Integer>();
                depth = curr_depth;
            }
            ls.add(store.remove(0));
        }
        result.add(ls);
        return result;
    }
}