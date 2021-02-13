import java.util.Random;

public class QuickSort {
    public static int[] quickSort(int[] arr){
        quickSortAlgo(0, arr.length - 1, arr);
        return arr;
    }

    public static void quickSortAlgo(int low, int high, int[] arr){
      if(low < high){
           int pivot = arr[low];
           int pivotIndex = low + 1;
           for(int i = low + 1; i <= high; i++){
               if(arr[i] < pivot){
                   swap(i, pivotIndex++, arr);
               }
           }
           swap(low, --pivotIndex, arr);
          quickSortAlgo(low, pivotIndex - 1, arr);
          quickSortAlgo(pivotIndex + 1, high, arr);
      }
    }

    private static void swap(int firstIndex, int secondIndex, int[] arr){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
