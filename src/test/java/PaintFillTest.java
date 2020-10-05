import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaintFillTest {
    private int[][] screen;
    @BeforeEach
    public void beforeEach()
    {
        screen = new int[][]{
                {1, 2, 2, 3, 2, 2},
                {3, 1, 1, 3, 1, 1},
                {3, 3, 1, 1, 2, 3},
                {2, 1, 1, 1, 2, 1},
                {3, 3, 1, 3, 2, 2}
        };
    }

    @Test
    public void paint_WhenNewColorSameAsOriginalColor_DoNothing(){
        PaintFill.paint(screen, 2, 2, 1);

        assertThat(screen).isDeepEqualTo(new int[][]{
                {1, 2, 2, 3, 2, 2},
                {3, 1, 1, 3, 1, 1},
                {3, 3, 1, 1, 2, 3},
                {2, 1, 1, 1, 2, 1},
                {3, 3, 1, 3, 2, 2}
        });
    }

    @Test
    public void paint_WhenNewColorIsDifferFromOriginalColor_BrushScreenWithNewColor(){
        PaintFill.paint(screen, 2, 2, 2);

        assertThat(screen).isDeepEqualTo(new int[][]{
                {1, 2, 2, 3, 2, 2},
                {3, 2, 2, 3, 1, 1},
                {3, 3, 2, 2, 2, 3},
                {2, 2, 2, 2, 2, 1},
                {3, 3, 2, 3, 2, 2}
        });
    }
}
