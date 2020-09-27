import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    public void quickSortTest(){
        int[] arr = new int[]{3, 5, 10, 200, -40, 88, 666, 50, 33, -243, 1000, 666};

        QuickSort.quickSort(arr);

        assertThat(arr).isSorted();
    }

}
