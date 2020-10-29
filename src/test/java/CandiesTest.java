import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandiesTest {
    @Test
    public void Candies_SimpleCase_ReturnMinimumCandies(){
        int[] input = new int[]{2, 4, 3, 5, 2, 6, 4, 5};

        assertThat(Candies.candies(8, input)).isEqualTo(12);
    }
}
