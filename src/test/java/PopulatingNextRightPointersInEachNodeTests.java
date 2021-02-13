import org.junit.jupiter.api.Test;

public class PopulatingNextRightPointersInEachNodeTests {
    @Test
    public void connect_SimpleInput_ReturnCorrectResult(){
        Node root = new Node(1);
        Node rootLeft = new Node(2);
        Node rootRight = new Node(3);
        Node rootLeftLeft = new Node(4);
        Node rootLeftRight = new Node(5);
        Node rootRightLeft = new Node(6);
        Node rootRightRight = new Node(7);

        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        PopulatingNextRightPointersInEachNode sut = new PopulatingNextRightPointersInEachNode();

        Node acutal = sut.connect(root);


    }
}
