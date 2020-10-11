import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankFromStreamTest {
    @Test
    public void algo_GivenAStream_FindRankOfNumberCorrectly(){
        RankFromStream rfs = new RankFromStream();

        rfs.track(5);
        rfs.track(1);
        rfs.track(4);
        rfs.track(4);
        rfs.track(5);
        rfs.track(9);
        rfs.track(7);
        rfs.track(13);
        rfs.track(3);

        assertThat(rfs.getRankOfNumber(1)).isEqualTo(0);
//        assertThat(rfs.getRankOfNumber(3)).isEqualTo(1);
//        assertThat(rfs.getRankOfNumber(4)).isEqualTo(3);
//        assertThat(rfs.getRankOfNumber(5)).isEqualTo(5);
//        assertThat(rfs.getRankOfNumber(7)).isEqualTo(6);
//        assertThat(rfs.getRankOfNumber(9)).isEqualTo(7);
//        assertThat(rfs.getRankOfNumber(13)).isEqualTo(8);
    }
}
