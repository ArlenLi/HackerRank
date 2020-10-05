import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinsTest {
    @Test
    public void change_WhenInputIs25_ReturnCorrectNum(){
        int actual = Coins.change(25);

        assertThat(actual).isEqualTo(13);
    }

    @Test
    public void change_WhenInputIs1_ReturnCorrectNum(){
        int actual = Coins.change(1);

        assertThat(actual).isEqualTo(1);
    }

    public void change_WhenInputIs10_ReturnCorrectNum(){
        int actual = Coins.change(10);

        assertThat(actual).isEqualTo(4);
    }
}
