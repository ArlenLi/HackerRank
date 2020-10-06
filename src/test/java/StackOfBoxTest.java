import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StackOfBoxTest {
    @Test
    public void calculateHighestStack_WhenInputIsEmpty_ReturnZero(){
        int actual = StackOfBoxes.calculateHighestStack(new ArrayList<>());

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void calculateHighestStack_WhenInputIsNotEmpty_ReturnCorrectHighest(){
        List<Box> boxes = new ArrayList<>(
            Arrays.asList(
                new Box(2, 4, 5),
                new Box(6, 1, 3),
                new Box(3, 2, 1),
                new Box(8, 3, 6))
        );

        int actual = StackOfBoxes.calculateHighestStack(boxes);

        assertThat(actual).isEqualTo(22);
    }
}
