import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinHeapTest {

    @Test
    public void Algo_GivenOperations_MainMinHeapProperty(){
        MinHeap minHeap = new MinHeap(100000);

        minHeap.insert(286789035);
        minHeap.insert(255653921);
        minHeap.insert(274310529);
        minHeap.insert(494521015);
        assertThat(minHeap.findMinimum()).isEqualTo(255653921);
        minHeap.delete(255653921);
        minHeap.delete(286789035);
        assertThat(minHeap.findMinimum()).isEqualTo(274310529);
        minHeap.insert(236295092);
        minHeap.insert(254828111);
        assertThat(minHeap.findMinimum()).isEqualTo(236295092);
        minHeap.delete(254828111);
        minHeap.insert(465995753);
        minHeap.insert(85886315);
        minHeap.insert(7959587);
        minHeap.insert(20842598);
        minHeap.delete(7959587);
        assertThat(minHeap.findMinimum()).isEqualTo(20842598);
        minHeap.insert(-51159108);
        assertThat(minHeap.findMinimum()).isEqualTo(-51159108);
        minHeap.delete(-51159108);
        assertThat(minHeap.findMinimum()).isEqualTo(20842598);
    }
}
