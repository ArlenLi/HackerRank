import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EightQueensTest {
    @Test
    public void eightQueensAlgo_Test(){
        List<int[]> actual = EightQueens.EightQueensAlgo();

        assertThat(actual.size()).isEqualTo(92);
    }
}
