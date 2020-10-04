import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AVLTreeTest {
    private AVLTree tree = new AVLTree();

    @BeforeEach
    private void beforeEach(){
        tree.insert(1);
        tree.insert(150);
        tree.insert(-50);
        tree.insert(666);
        tree.insert(33);
        tree.insert(-88);
        tree.insert(888);
        tree.insert(0);
        tree.insert(500);
        tree.insert(-999);
        tree.insert(-2500);
        tree.insert(250);
        tree.insert(10000);
        tree.insert(70);
        tree.insert(22);
    }

    @Test
    public void aVLTree_Insert_InOrderTraverseShouldBeAscending(){
        List<Integer> traversedList = tree.inOrderTraverse();

        assertThat(traversedList).isSorted();
    }

    @Test
    public void aVLTree_Insert_BalanceFactorShouldBeBetweenMinusOneAndOne(){
        traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(tree.root);
    }

    private void traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(AVLTreeNode node){
        if(node != null){
            traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(node.left);
            assertThat(node.balanceFactor).isGreaterThanOrEqualTo(-1);
            assertThat(node.balanceFactor).isLessThanOrEqualTo(1);
            traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(node.right);
        }
    }

    @Test
    public void aVLTree_Delete_InOrderTraverseShouldBeAscending(){
        boolean actual = tree.delete(666);

        List<Integer> traversedList = tree.inOrderTraverse();

        assertThat(actual).isTrue();
        assertThat(traversedList).isSorted();
    }

    @Test
    public void aVLTree_Delete_BalanceFactorShouldBeBetweenMinusOneAndOne(){
        boolean actual = tree.delete(500);
        assertThat(actual).isTrue();
        traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(tree.root);

        actual = tree.delete(10000);
        assertThat(actual).isTrue();
        traverseAVLTreeInOrder_AssertBalanceFactorShouldBeBetweenMinusOneAndOne(tree.root);
    }
}
