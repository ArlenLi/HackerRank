import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveDigitSumTest {
    @Test
    public void superDigit_WhenInputIsLongString_ReturnCorrectSuperDigit(){
        int actual = RecursiveDigitSum.superDigit("861568688536788", 100000);

        assertThat(actual).isEqualTo(3);
    }
}
