import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WordLadderTest {
    @Test
    public void test(){
        WordLadder sut = new WordLadder();

        int actual = sut.ladderLength("hit", "cog",  Arrays.asList("hot","dot","dog","lot","log","cog") );

        assertThat(actual).isEqualTo(5);
    }
}
