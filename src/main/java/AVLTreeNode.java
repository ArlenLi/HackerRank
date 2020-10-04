public class AVLTreeNode {
    public int data;
    public AVLTreeNode parent;
    public AVLTreeNode left;
    public AVLTreeNode right;
    public int balanceFactor;

    public AVLTreeNode(){

    }

    public AVLTreeNode(int data){
        this.data = data;
    }
}
