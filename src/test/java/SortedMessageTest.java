import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedMessageTest {
    private int[] a;
    private int[] b;
    private int[] expected;
    @BeforeEach
    public void beforeEach(){
        a = new int[]{-50, -20, 0, 1, 33, 66, 999, 2341, 4461, 10000, 0, 0, 0, 0, 0, 0, 0};
        b = new int[]{-10, 0, 5, 100, 500, 999};
        expected = new int[]{-50, -20, -10, 0, 0, 1, 5, 33, 66, 100, 500, 999, 999, 2341, 4461, 10000, 0};
    }

    @Test
    public void algo_GivenTwoSortedArray_ReturneMergedArrayCorrectly(){
        int[] actual = SortedMessage.algo(a, b);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void algoWithLastIndexes_GivenTwoSortedArray_ReturneMergedArrayCorrectly(){
        int[] actual = SortedMessage.algo(a, b, 9, 5);

        assertThat(actual).containsExactly(expected);
    }
}
