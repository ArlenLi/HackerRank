public class TrimABinarySearchTree {
    private TreeNode root = null;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.root = root;
        preOrderTraverse(root, null, false, low, high);
        return this.root;
    }

    private void preOrderTraverse(TreeNode node, TreeNode parent, boolean isLeft, int low, int high){
        if(node == null){
            return;
        }

        if(node.val >= low && node.val <= high){
            preOrderTraverse(node.left, node, true, low, high);
            preOrderTraverse(node.right, node, false, low, high);
        }else{
            if(node.val < low){
                node = node.right;
            }else{
                node = node.left;
            }

            if(parent == null){
                this.root = node;
            }else{
                if(isLeft){
                    parent.left = node;
                }else{
                    parent.right = node;
                }
            }
            preOrderTraverse(node, parent, isLeft, low, high);
        }
    }
}
