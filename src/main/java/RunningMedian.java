public class RunningMedian {

    public static double[] runningMedian(int[] a){
        int maxSize = a.length / 2 + 1;

        MaxHeap maxHeap = new MaxHeap(maxSize);
        MinHeap minHeap = new MinHeap(maxSize);

        double[] result = new double[a.length];
        for(int i = 0; i < a.length; i++){
            if(i == 0){
                result[0] = a[0];
            } else if(i == 1){
                if(a[0] > a[1]){
                    minHeap.insert(a[0]);
                    maxHeap.insert(a[1]);
                }else{
                    minHeap.insert(a[1]);
                    maxHeap.insert(a[0]);
                }
                result[1] = (double)(a[0] + a[1]) / 2;
            } else{
                if(a[i] > minHeap.getMinimum())
                {
                    minHeap.insert(a[i]);
                }else{
                    maxHeap.insert(a[i]);
                }

                if(minHeap.size - maxHeap.size == 2){
                    maxHeap.insert(minHeap.removeMinimum());
                }

                if(maxHeap.size - minHeap.size == 2){
                    minHeap.insert(maxHeap.removeMaximum());
                }

                if(i % 2 == 0){
                    result[i] = minHeap.size > maxHeap.size ? minHeap.getMinimum() : maxHeap.getMaximum();
                }else{
                    result[i] = (double)(minHeap.getMinimum() + maxHeap.getMaximum()) / 2;
                }
            }
        }
        return result;
    }
    private static class MaxHeap{
        private int[] arr;
        public int size;

        public MaxHeap(int maxSize){
            this.arr = new int[maxSize];
            size = 0;
        }

        public MaxHeap(int[] arr){
            this.arr = arr;
            this.size = arr.length;
            for(int i = this.arr.length / 2 - 1; i >= 0; i--){
                heapify(i);
            }
        }

        public int getMaximum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            return arr[0];
        }

        public int removeMaximum(){
            if(size == 0){
                throw new IllegalStateException("Heap is empty");
            }

            int removedElement = arr[0];
            arr[0] = arr[--size];
            heapify(0);

            return removedElement;
        }

        public void insert(int element){
            if(size == arr.length){
                throw new IllegalStateException("Heap is full");
            }

            arr[size++] = element;

            int current = size - 1;
            int parent = getParentIndex(current);

            while(current != 0 && arr[current] > arr[parent]){
                swap(current, parent);
                current = parent;
                parent = getParentIndex(current);
            }
        }

        private void heapify(int index){
            if(index > size || isLeaf(index)){
                return;
            }

            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);

            if(arr[index] < arr[leftChildIndex]
            || (rightChildIndex < size && arr[index] < arr[rightChildIndex])){
                if(rightChildIndex >= size || arr[leftChildIndex] > arr[rightChildIndex]){
                    swap(index, leftChildIndex);
                    heapify(leftChildIndex);
                }else{
                    swap(index, rightChildIndex);
                    heapify(rightChildIndex);
                }
            }
        }

        private void swap(int index1, int index2){
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
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
    }

    private static class MinHeap{
        private int[] arr;
        public int size;

        public MinHeap(int maxSize){
            arr = new int[maxSize];
            size =0;
        }

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

        private int getMinimum(){
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
            if(index > size || isLeaf(index)){
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
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
