import java.util.Arrays;
import java.util.Comparator;

public class MinimumAverageWaitingTime {
    public static long minimumAverage(int[][] customers){
        Arrays.sort(customers, Comparator.comparingInt((int[] customer) -> customer[0]));

        int arrivedCustomerCount = 0;
        long startTime = 0;
        long finishTime = 0;
        long totalWaitTime = 0;
        MinHeap minHeap = new MinHeap(customers.length);

        int i = 0;
        while(i < customers.length){
            if(minHeap.isEmpty() && arrivedCustomerCount < customers.length){
                minHeap.insert(customers[arrivedCustomerCount++]);
            }

            int[] nextOrderInfo = minHeap.removeMinimum();
            if(startTime < nextOrderInfo[0]){
                startTime = nextOrderInfo[0];
            }
            finishTime = startTime + nextOrderInfo[1];

            while(arrivedCustomerCount < customers.length && customers[arrivedCustomerCount][0] <= finishTime){
                minHeap.insert(customers[arrivedCustomerCount++]);
            }

            totalWaitTime += finishTime - nextOrderInfo[0];
            startTime = finishTime;
            i++;
        }

        return totalWaitTime / customers.length;
    }

    private static class MinHeap{
        private int[][] arr;
        public int size;

        public MinHeap(int maxSize){
            arr = new int[maxSize][];
            size =0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        private int[] removeMinimum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            int[] removedElement = arr[0];
            arr[0] = arr[--size];
            heapify(0);
            return removedElement;
        }

        private int[] getMinimum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            return arr[0];
        }

        private void insert(int[] elemenet){
            if(size == arr.length){
                throw new IllegalStateException("heap is full");
            }

            arr[size++] = elemenet;
            int current = size - 1;
            int parent = getParentIndex(current);

            while(current != 0 && arr[current][1] < arr[parent][1]){
                swap(current, parent);
                current = parent;
                parent =getParentIndex(parent);
            }
        }

        private void heapify(int index){
            if(index > size || isLeaf(index)){
                return;
            }

            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            if(arr[index][1] > arr[leftChildIndex][1]
                    || (rightChildIndex < size && arr[index][1] > arr[rightChildIndex][1])){
                if(rightChildIndex >= size || arr[leftChildIndex][1] < arr[rightChildIndex][1]){
                    swap(index, leftChildIndex);
                    heapify(leftChildIndex);
                }else{
                    swap(index, rightChildIndex);
                    heapify(rightChildIndex);
                }
            }
        }

        private boolean isLeaf(int index){
            if(index > size / 2 - 1){
                return true;
            }else{
                return false;
            }
        }

        private int getParentIndex(int index){
            return (index - 1) / 2;
        }

        private int getLeftChildIndex(int index){
            return index * 2 + 1;
        }

        private int getRightChildIndex(int index){
            return index * 2 + 2;
        }

        private void swap(int index1, int index2){
            int[] temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

}
