import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumOperationsToReduceXtoZeroTests {
    @Test
    public void minOperations_SimpleCase_ReturnCorrectResult(){
        int[] input = new int[]{1, 1, 4, 2, 3};

        MinimumOperationsToReduceXtoZero sut = new MinimumOperationsToReduceXtoZero();
        int actual = sut.minOperations(input, 5);

        assertThat(actual).isEqualTo(2);
    }
}
