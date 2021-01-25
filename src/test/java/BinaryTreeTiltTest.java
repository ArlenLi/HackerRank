import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTiltTest {
    @Test
    public void findTilt_SimpleInput_ReturnCorrectResult(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        BinaryTreeTilt sut = new BinaryTreeTilt();

        assertThat(sut.findTilt(root)).isEqualTo(1);
    }
}
