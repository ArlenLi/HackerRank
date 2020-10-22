import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JessAndCookiesTest {
    @Test
    public void cookies_GivenCookiesAndTargetSweetness_ReturnCorrectOperationsCount(){
        assertThat(JessAndCookies.cookies(7, new int[]{1 ,2, 3, 9, 10, 12} )).isEqualTo(2);
    }
}
