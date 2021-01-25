public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] sum = new int[1];
        postTraverse(root, sum);
        return sum[0];
    }

    private int postTraverse(TreeNode node, int[] sum){
        if(node == null){
            return 0;
        }

        int leftSum = postTraverse(node.left, sum);
        int rightSum = postTraverse(node.right, sum);

        sum[0] += Math.abs(leftSum - rightSum);
        return leftSum + node.val + rightSum;
    }
}
