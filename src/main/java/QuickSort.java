public class QuickSort {
    public static int[] quickSort(int[] arr){
        quickSortAlgo(0, arr.length - 1, arr);
        return arr;
    }

    public static void quickSortAlgo(int low, int high, int[] arr){
        int pivotIndex = partition(low, high, arr);
        if(pivotIndex >= 0) {
            quickSortAlgo(low, pivotIndex - 1, arr);
            quickSortAlgo(pivotIndex + 1, high, arr);
        }
    }

    public static int partition(int low, int high, int[] arr){
        int pivotIndex = -1;
        if(low < high){
            int pivot = arr[low];
            pivotIndex = low + 1;
            for(int k = low + 1; k <= high; k++){
                if(arr[k] < pivot){
                    swap(k, pivotIndex, arr);
                    pivotIndex++;
                }
            }
            swap(low, pivotIndex - 1, arr);
        }
        return pivotIndex - 1;
    }

    private static void swap(int firstIndex, int secondIndex, int[] arr){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
