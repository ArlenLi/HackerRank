import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationWithDupTest {
    @Test
    public void algo_WhenInputIsEmptyString_ReturnCorrectPermutation(){
        List<String> actual = PermutationWithDup.algo("");

        assertThat(actual).containsExactly("");
    }

    @Test
    public void algo_WhenInputIsNoDupString_ReturnCorrectPermutation(){
        List<String> actual = PermutationWithDup.algo("abc");

        assertThat(actual).containsExactlyInAnyOrder("abc", "acb", "bac", "bca", "cab", "cba");
    }

    @Test
    public void algo_WhenInputIsDupString_ReturnCorrectPermutation(){
        List<String> actual = PermutationWithDup.algo("acccbaac");

        assertThat(actual).containsExactlyInAnyOrder("abc", "acb", "bac", "bca", "cab", "cba");
    }
}
