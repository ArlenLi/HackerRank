import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParensTest {
    @Test
    public void parensAlgo_WhenInputIsZero_ReturnEmptyList(){
        List<String> actual = Parens.algo1(0);

        assertThat(actual).isEmpty();
    }

    @Test
    public void parensAlgo_WhenInputIsThree_ReturnValidParentheses(){
        List<String> actual = Parens.algo1(3);

        assertThat(actual).containsExactlyInAnyOrder("()()()", "(()())","(())()","((()))","()(())");
    }
}
