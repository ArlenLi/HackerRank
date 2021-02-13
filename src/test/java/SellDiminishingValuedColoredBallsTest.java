import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellDiminishingValuedColoredBallsTest {
    @Test
    public void SellDiminishingValuedColoredBalls_test(){
        SellDiminishingValuedColoredBalls sut = new SellDiminishingValuedColoredBalls();

        int[] input = new int[]{565259708,715164401,716563713,958255469,844600740,823949511,180479359,287829385,164248818,73361150,230686692,322986846,598720034,338241127,748922260,181241085,833659853,509571179,250093451,690995620,703292727,595636202};
        int actual = sut.maxProfit(input, 650114768);

        assertThat(actual).isEqualTo(997286992);
    }
}
