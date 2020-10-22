import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumAverageWaitingTimeTest {
    @Test
    public void minimumAverage_GivenAnArrayOfCustomers_ReturnCorrectMinimumAverage(){
        int[][] customers = new int[][]{
                {961148050, 385599125},
                {951133776, 376367013},
                {283280121, 782916802},
                {317664929, 898415172},
                {980913391, 847912645}
        };

        long actual = MinimumAverageWaitingTime.minimumAverage(customers);

        assertThat(actual).isEqualTo(1418670047);
    }
}
