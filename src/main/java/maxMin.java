import java.util.Arrays;

public class maxMin {
    public static int maxMinAlgo(int k, int[] arr){
        Arrays.sort(arr);
        int minimumUnfairness = Integer.MAX_VALUE;
        for(int i = k - 1; i < arr.length; i++){
            if(arr[i] - arr[i - k + 1] < minimumUnfairness){
                minimumUnfairness = arr[i] - arr[i - k + 1];
            }
        }
        return minimumUnfairness;
    }
}
