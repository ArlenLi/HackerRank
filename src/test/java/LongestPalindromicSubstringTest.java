import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromicSubstringTest {
    @Test
    public void LongestPalindromic_WhenInputNotContainPalindromic_ReturnEitherChar(){
        String input = "cabac";

        String actual = LongestPalindromicSubstring.longestPalindrome(input);

        assertThat(actual.length()).isEqualTo(5);
    }
}
