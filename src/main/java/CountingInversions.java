public class CountingInversions {
    static long countInversions(int[] arr) {
        return mergeSort(0, arr.length - 1, arr);
    }

    static long mergeSort(int low, int high, int[] arr){
        if(low >= high){
            return 0;
        }
        int[] temp = new int[high - low + 1];
        int mid = (high + low) / 2;
        long leftSwapCount = mergeSort(low, mid, arr);
        long rightSwapCount = mergeSort(mid + 1, high, arr);
        long mergeSwapCount = 0;
        int index = 0;
        int leftIndex = low;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= high)
        {
            if(arr[rightIndex] < arr[leftIndex]){
                temp[index++] = arr[rightIndex++];
                mergeSwapCount += (mid - leftIndex + 1);
            }else{
                temp[index++] = arr[leftIndex++];
            }
        }
        while(leftIndex <= mid){
            temp[index++] = arr[leftIndex++];
        }
        while(rightIndex <= high){
            temp[index++] = arr[rightIndex++];
        }

        for(int i = 0; i < temp.length; i++){
            arr[low + i] = temp[i];
        }
        return leftSwapCount + rightSwapCount + mergeSwapCount;
    }
}
