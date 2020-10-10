import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SparseSearchTest {
    String[] arr;

    @BeforeEach
    public void beforeEach(){
        arr = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
    }

    @Test
    public void algo_WhenTargetIsEmptyString_ReturnFirstEmptyString(){
        int actual = SparseSearch.algo(arr, "");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void algo_WhenTargetIsNotEmptyString_ReturnIndexOfAnyMatchingString(){
        int actual = SparseSearch.algo(arr, "ball");

        assertThat(actual).isEqualTo(4);
    }
}
