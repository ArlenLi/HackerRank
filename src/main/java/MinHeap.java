public class MinHeap {
    private final int root = 1;
    private int size;
    private int[] arr;

    public MinHeap(int maxSize){
        arr = new int[maxSize + 1];
        arr[0] = Integer.MIN_VALUE;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index){
        return index * 2;
    }

    private int rightChild(int index){
        return index * 2 + 1;
    }

    public void insert(int element){
        if(size > arr.length - 1){
            throw new IllegalStateException("heap is full");
        }

        arr[++size] = element;

        upwardsHeapify(size);
    }

    public int findMinimum(){
        if(size == 0){
            throw new IllegalStateException("Heap is empty");
        }

        return arr[root];
    }

    public void deleteRoot(){
        if(size == 0){
            return;
        }

        arr[root] = arr[size--];

        downwardHeapify(root);
    }

    public void delete(int element){
        int i;
        for(i = 1; i <= size; i++){
            if(arr[i] == element){
                break;
            }
        }
        if(i != size) {
            arr[i] = arr[size--];

            if (arr[i] < arr[parent(i)]) {
                upwardsHeapify(i);
            } else {
                downwardHeapify(i);
            }
        } else{
            size--;
        }
    }

    private void downwardHeapify(int index){
        if(isLeaf(index)){
            return;
        }

        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        if(arr[index] > arr[leftChild] || arr[index] > arr[rightChild]){
            if(arr[leftChild] < arr[rightChild]){
                swap(index, leftChild);
                downwardHeapify(leftChild);
            }else{
                swap(index, rightChild);
                downwardHeapify(rightChild);
            }
        }
    }

    private boolean isLeaf(int index){
        if(index <= size && index > size / 2){
            return true;
        }else{
            return false;
        }
    }

    private void upwardsHeapify(int index){
        int parent = parent(index);
        while(arr[index] < arr[parent]){
            swap(index, parent);
            index = parent;
            parent = parent(index);
        }
    }

    private void swap(int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
