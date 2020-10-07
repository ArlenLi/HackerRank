import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanEvaluationTest {
    @Test
    public void countParenthesizing_SimpleCase_ReturnCorrectCounting(){
        int actual = BooleanEvaluation.countParenthesizing("1^0|0|1", false);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void countParenthesizing_ComplexCase_ReturnCorrectCounting(){
        int actual = BooleanEvaluation.countParenthesizing("0&0&0&1^1|0", true);

        assertThat(actual).isEqualTo(10);
    }
}
