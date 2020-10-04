import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    public AVLTreeNode root;

    public void insert(int insertedValue){
       if(root == null){
           root = new AVLTreeNode(insertedValue);
           return;
       }

       AVLTreeNode node = root;
       AVLTreeNode parent = null;

       while(node != null){
           parent = node;
           if(insertedValue < node.data){
               node = node.left;
           }else{
               node = node.right;
           }
       }

       AVLTreeNode insertedNode = new AVLTreeNode(insertedValue);
       insertedNode.parent = parent;
       if(insertedValue < parent.data){
           parent.left = insertedNode;
           parent.balanceFactor--;
       }else{
           parent.right = insertedNode;
           parent.balanceFactor++;
       }
       rebalance(parent);
    }

    public boolean delete(int toBeDeleted){
        return delete(root, toBeDeleted);
    }

    private boolean delete(AVLTreeNode node, int toBeDeleted){
        while(node != null){
            if(toBeDeleted < node.data){
                node = node.left;
            } else if(toBeDeleted > node.data){
                node = node.right;
            }else{
                AVLTreeNode parent = node.parent;
                if(node.left == null && node.right == null){
                    if(parent == null){
                        root = null;
                    }else{
                        if(parent.left == node){
                            parent.left = null;
                            parent.balanceFactor++;
                        }else{
                            parent.right = null;
                            parent.balanceFactor--;
                        }
                        rebalance(parent);
                    }
                    return true;
                }else if(node.left == null){
                    if(parent == null){
                        root = node.right;
                    }else {
                        if (parent.left == node) {
                            node.right.parent = parent;
                            parent.left = node.right;
                            parent.balanceFactor++;
                        } else {
                            node.right.parent = parent;
                            parent.right = node.right;
                            parent.balanceFactor--;
                        }
                        rebalance(parent);
                    }
                    return true;
                }else if(node.right == null){
                    if(parent == null){
                        root = node.left;
                    } else{
                        if(parent.left == node){
                            node.left.parent = parent;
                            parent.left = node.left;
                            parent.balanceFactor++;
                        }else{
                            node.left.parent = parent;
                            parent.right = node.left;
                            parent.balanceFactor--;
                        }
                        rebalance(parent);
                    }
                    return true;
                }else{
                    int temp = findTreeMinimum(node.right);
                    node.data = temp;
                    delete(node.right, temp);
                    return true;
                }
            }
        }
        return false;
    }

    private int findTreeMinimum(@org.jetbrains.annotations.NotNull AVLTreeNode node){
        while(true){
            if(node.left != null){
                node = node.left;
            }else{
                break;
            }
        }
        return node.data;
    }

    public void rebalance(AVLTreeNode node){
        balance(node);
        if(node.balanceFactor != 0 && node.parent != null){
            if(node == node.parent.left){
                node.parent.balanceFactor--;
            }else{
                node.parent.balanceFactor++;
            }
            rebalance(node.parent);
        }
    }

    public void balance(AVLTreeNode node){
        if(node.balanceFactor < -1){
            if(node.left.balanceFactor > 0){
                leftRotate(node.left);
            }
            rightRotate(node);
        }
        if(node.balanceFactor > 1){
            if(node.right.balanceFactor < 0){
                rightRotate(node.right);
            }
            leftRotate(node);
        }
    }

    public void leftRotate(AVLTreeNode node){
        AVLTreeNode nodeRight = node.right;
        node.right = nodeRight.left;
        if(node.right != null)
        {
            node.right.parent = node;
        }
        nodeRight.parent = node.parent;
        if(node.parent == null){
            root = nodeRight;
        }else{
            if(node.parent.left == node){
                node.parent.left = nodeRight;
            }else{
                node.parent.right = nodeRight;
            }
        }
        nodeRight.left = node;
        node.parent = nodeRight;

        node.balanceFactor = node.balanceFactor - 1 - Math.max(0, nodeRight.balanceFactor);
        nodeRight.balanceFactor = nodeRight.balanceFactor - 1 + Math.min(0, node.balanceFactor);
    }

    public void rightRotate(AVLTreeNode node){
        AVLTreeNode nodeLeft = node.left;
        node.left = nodeLeft.right;
        if(node.left != null){
            node.left.parent = node;
        }

        nodeLeft.parent = node.parent;
        if(node.parent == null){
            root = nodeLeft;
        }else{
            if(node.parent.left == node){
                node.parent.left = nodeLeft;
            }else{
                node.parent.right = nodeLeft;
            }
        }
        nodeLeft.right = node;
        node.parent = nodeLeft;

        node.balanceFactor = node.balanceFactor + 1 - Math.min(0, nodeLeft.balanceFactor);
        nodeLeft.balanceFactor = nodeLeft.balanceFactor + 1 + Math.max(0, node.balanceFactor);
    }

    public List<Integer> inOrderTraverse(){
        List<Integer> inOrderTraversedList = new ArrayList<Integer>();
        traverse(root, inOrderTraversedList);
        return inOrderTraversedList;
    }

    private void traverse(AVLTreeNode node, List<Integer> list){
        if(node != null){
            traverse(node.left, list);
            list.add(node.data);
            traverse(node.right, list);
        }
    }
}


