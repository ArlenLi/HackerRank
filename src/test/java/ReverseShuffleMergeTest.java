import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseShuffleMergeTest {
    @Test
    public void ReverseShuffleMerge_WhenInputIseggegg_Returnegg(){
        assertThat(ReverseShuffleMerge.reverseShuffleMerge("eggegg")).isEqualTo("egg");
    }
}
