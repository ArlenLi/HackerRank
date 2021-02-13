import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoadAndLibrariesTest {
    @Test
    public void roadAndLibraries_SmallInput_ReturnMinimumCost(){
        int[][] roads = new int[][]{
                {1, 2},
                {3, 1},
                {2, 3}
        };

        long actual = RoadsAndLibraries.roadsAndLibraries(3, 2, 1, roads);

        assertThat(actual).isEqualTo(4);

        int[][] roads2 = new int[][]{
                {1, 3},
                {3, 4},
                {2, 4},
                {1, 2},
                {2, 3},
                {5, 6}
        };

        actual = RoadsAndLibraries.roadsAndLibraries(6, 2, 5,roads2);
        assertThat(actual).isEqualTo(12);
    }

}
