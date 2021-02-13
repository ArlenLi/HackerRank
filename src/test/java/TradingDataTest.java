import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradingDataTest {
    @Test
    public void tradingData_test(){
        int[] systemA = new int[]{7, 7, 7, 7};
        int[] systemB = new int[]{4, 7};

        int[] actual = TradingData.tradingData(systemA, systemB);

        assertThat(actual).containsExactly(0, 4);
    }
}
