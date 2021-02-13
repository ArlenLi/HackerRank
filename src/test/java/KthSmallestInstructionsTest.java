import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestInstructionsTest {
    @Test
    public void algo_SmallInput_ReturnCorrectPath(){
        String actual = KthSmallestInstructions.kthSmallestPath(new int[]{2,2}, 4);

        assertThat(actual).isEqualTo("VHHV");
    }
}
