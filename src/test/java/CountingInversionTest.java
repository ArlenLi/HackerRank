import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingInversionTest {
    @Test
    public void countInversions_smallTestCase(){
        int[] input = new int[]{2, 1, 3, 1, 2};

        long actual = CountingInversions.countInversions(input);

        assertThat(actual).isEqualTo(4);
    }
}
