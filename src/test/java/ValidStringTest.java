import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidStringTest {
    @Test
    public void isValid_InputIsaabbcd_ReturnNo(){
        String actual = ValidString.isValid("abcdefghhgfedecba");

        assertThat(actual).isEqualTo("YES");
    }
}