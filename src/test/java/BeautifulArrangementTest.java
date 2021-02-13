import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeautifulArrangementTest {
    @Test
    public void test(){
        BeautifulArrangement sut = new BeautifulArrangement();

        assertThat(sut.countArrangement(6)).isEqualTo(36);
    }
}
