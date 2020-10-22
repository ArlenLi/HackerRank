public class JessAndCookies {
    public static int cookies(int targetSweetness, int[] cookies){
        MinHeap minHeap = new MinHeap(cookies);
        int count = 0;

        while(minHeap.size > 1 && minHeap.findMinimum() < targetSweetness){
            int leastSweetCookie = minHeap.removeMinimum();
            int secondLeastSweetCookie = minHeap.removeMinimum();
            int mixedCookie = leastSweetCookie + 2 * secondLeastSweetCookie;
            minHeap.insert(mixedCookie);
            count++;
        }

        if(minHeap.findMinimum() >= targetSweetness){
            return count;
        }else{
            return -1;
        }
    }

    private static class MinHeap{
        private int[] arr;
        public int size;

        public MinHeap(int[] arr){
            this.arr = arr;
            this.size = arr.length;
            for(int i = this.arr.length / 2 - 1; i >= 0; i--){
                heapify(i);
            }
        }

        private int removeMinimum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            int removedElement = arr[0];
            arr[0] = arr[--size];
            heapify(0);
            return removedElement;
        }

        private int findMinimum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            return arr[0];
        }

        private void insert(int elemenet){
            if(size == arr.length){
                throw new IllegalStateException("heap is full");
            }

            arr[size++] = elemenet;
            int current = size - 1;
            int parent = getParentIndex(current);

            while(current != 0 && arr[current] < arr[parent]){
                swap(current, parent);
                current = parent;
                parent =getParentIndex(parent);
            }
        }

        private void heapify(int index){
            if(isLeaf(index)){
                return;
            }

            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            if(arr[index] > arr[leftChildIndex]
                    || (rightChildIndex < size && arr[index] > arr[rightChildIndex])){
                if(rightChildIndex >= size || arr[leftChildIndex] < arr[rightChildIndex]){
                    swap(index, leftChildIndex);
                    heapify(leftChildIndex);
                }else{
                    swap(index, rightChildIndex);
                    heapify(rightChildIndex);
                }
            }
        }

        private boolean isLeaf(int index){
            if(index < size && index > size / 2 - 1){
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
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
