import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsWithoutDupTest {
    @Test
    public void algo_WhenInputIsEmptyString_ReturnCorrectPermutation(){
        List<String> actual = PermutationsWithoutDup.algo("");

        assertThat(actual).containsOnly("");
    }

    @Test
    public void algo_WhenInputIsNotEmptyString_ReturnCorrectPermutation(){
        List<String> actual = PermutationsWithoutDup.algo("abc");

        assertThat(actual).containsExactlyInAnyOrder("abc", "acb", "bac", "bca", "cab", "cba");
    }
}
