import org.assertj.core.internal.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListRandomNodeTests {
    @Test
    public void getRandom_smallTestCase(){
        // Arrange
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode sut = new LinkedListRandomNode(head);

        // Act
        int result = sut.getRandom();

        // Assert
        assertThat(result).isIn(1, 2, 3);
    }
}
