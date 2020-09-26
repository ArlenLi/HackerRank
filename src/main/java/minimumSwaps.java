public class minimumSwaps {
    public static int minimumSwapsAlgo(int[] arr){
        int minimumSwaps = 0;
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i + 1){
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
                minimumSwaps++;
            }
        }
        return minimumSwaps;
    }
}
