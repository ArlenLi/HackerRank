import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupAnagramTest {
    @Test
    public void algo_GivenInput_ReturnGroupedAnagram(){
        String[] arr = new String[]{"abc", "def", "bac", "efsasda", "asfaa", "fed"};
        String[] actual = GroupAnagram.algo(arr);

        assertThat(actual).containsExactly("abc", "bac", "def", "fed", "efsasda", "asfaa");

    }
}
