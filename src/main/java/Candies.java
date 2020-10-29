public class Candies {
    public static long candies(int n, int[] arr) {
       int[] candies = new int[arr.length];

       candies[0] = 1;
       for(int i = 1; i < arr.length; i++){
           if(arr[i] > arr[i - 1]){
               candies[i] = candies[i - 1] + 1;
           }else{
               candies[i] = 1;
           }
       }

       long sum = candies[arr.length - 1];
       candies[arr.length - 1] = 1;
       for(int i = arr.length - 2; i >= 0; i--){
           if(arr[i] > arr[i + 1]){
               sum += Math.max(candies[i], candies[i + 1] + 1);
               candies[i] = candies[i + 1] + 1;
           }else{
               sum += candies[i];
           }
       }
       return sum;
    }
}
