import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class longestStableMarketPriodTest {
    @Test
    public void longestStableMarketPriod_test(){
        int[] input = new int[]{1, 2, 1, 2, 2, 1, 3, 1, 1, 2, 2, 2, 2};

        int[] actual = LongestStableMarketPeriod.longestStableMarketPriod(input, 1);

        assertThat(actual).containsExactly(1, 2, 1, 2, 2, 1);
    }
}
