import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SetMatrixZerosTests {
    @Test
    public void setZeroes_SimpleInput_ReturnCorrectMatrix(){
        int[][] input = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1,3,1,5}
        };

        SetMatrixZeros sut = new SetMatrixZeros();
        sut.setZeroes(input);

        assertThat(input).isDeepEqualTo(new int[][]{
                {0,0,0,0},{0,4,5,0},{0,3,1,0}
        });
    }
}
