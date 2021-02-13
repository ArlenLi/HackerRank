import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrimABinarySearchTreeTest {
    @Test
    public void trimBST_Test(){
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(0);
        TreeNode rootRight = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(2);
        TreeNode rootLeftRightLeft = new TreeNode(1);

        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.right = rootLeftRight;
        rootLeftRight.left = rootLeftRightLeft;

        TrimABinarySearchTree sut = new TrimABinarySearchTree();
        TreeNode actual = sut.trimBST(root, 1,1);

        assertThat(actual.val).isEqualTo(1);

    }
}
