public class ArrayManipulation {
    public static long arrayManipulationAlgo(int n, int[][] queries){
        int[] arr = new int[n];
        for(int i = 0; i < queries.length; i++){
            arr[queries[i][0] - 1] += queries[i][2];
            if(queries[i][1] < n){
                arr[queries[i][1]] -= queries[i][2];
            }
        }

        long max = 0;
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum +=arr[i];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
