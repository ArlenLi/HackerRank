import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateSortedArrayThroughInstructionsTest {
    @Test
    public void createSortedArray_Test(){
        int[] input = new int[]{1,3,3,3,2,4,2,1,2};

        CreateSortedArrayThroughInstructions sut = new CreateSortedArrayThroughInstructions();
        int actual = sut.createSortedArray(input);

        assertThat(actual).isEqualTo(4);
    }
}
