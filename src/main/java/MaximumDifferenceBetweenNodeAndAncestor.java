import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root){
        int[] max = new int[1];

        postOrderTraverse(root, max);

        return max[0];
    }

    private List<Integer> postOrderTraverse(TreeNode node, int[] max){
        if(node == null || (node.left == null && node.right == null)){
            return new ArrayList<>();
        }

        List<Integer> leftList = postOrderTraverse(node.left, max);
        List<Integer> rightList = postOrderTraverse(node.right, max);

        List<Integer> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        if(node.left != null){
            int diffBetweenLeft = node.val - node.left.val;
            leftList.add(0);

            for(int num : leftList){
                if(diffBetweenLeft + num < minDiff){
                    minDiff = diffBetweenLeft + num;
                }

                if(diffBetweenLeft + num > maxDiff){
                    maxDiff = diffBetweenLeft + num;
                }
            }
        }

        if(node.right != null){
            int diffBetweenRight = node.val - node.right.val;
            rightList.add(0);

            for(int num : rightList){
                if(diffBetweenRight + num < minDiff){
                    minDiff = diffBetweenRight + num;
                }

                if(diffBetweenRight + num > maxDiff){
                    maxDiff = diffBetweenRight + num;
                }
            }
        }

        if(Math.abs(minDiff) > max[0] || Math.abs(maxDiff) > max[0]){
            max[0] = Math.abs(minDiff) > Math.abs(maxDiff) ? Math.abs(minDiff) : Math.abs(maxDiff);
        }

        list.add(minDiff);
        list.add(maxDiff);

        return list;
    }
}
