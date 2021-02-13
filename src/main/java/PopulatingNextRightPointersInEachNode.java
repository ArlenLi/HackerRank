import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
       if(root == null){
           return null;
       }

       Node levelStart = root;
       while(levelStart.left != null){
           Node parent = levelStart;
           Node child = parent.left;
           while(child != null){
               if(child == parent.left){
                   child.next = parent.right;
               }else{
                   child.next = parent.next != null ? parent.next.left : null;
                   parent = parent.next;
               }
               child = child.next;
           }
           levelStart = levelStart.left;
       }
       return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
