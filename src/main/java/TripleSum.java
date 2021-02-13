import java.util.Arrays;
import java.util.stream.IntStream;

public class TripleSum {
    static long triplets(int[] a, int[] b, int[] c){
        a = IntStream.of(a).distinct().toArray();
        b = IntStream.of(b).distinct().toArray();
        c = IntStream.of(c).distinct().toArray();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long sum = 0;
        for (int j : b) {
            long aIndex = binarySearch(a, j);
            if (aIndex < 0) {
                aIndex = -aIndex - 2;
            }
            long cIndex = binarySearch(c, j);
            if (cIndex < 0) {
                cIndex = -cIndex - 2;
            }

            sum += (aIndex + 1) * (cIndex + 1);
        }
        return sum;
    }

    static int binarySearch(int[] arr, int val){
        return binarySearch(arr, val, 0, arr.length - 1);
    }

    static int binarySearch(int[] arr, int val, int low, int high){
        if(low <= high){
            int mid = (low + high) / 2;
            if(val < arr[mid]){
                return binarySearch(arr, val, low, mid - 1);
            }else if(val > arr[mid]){
                return binarySearch(arr, val, mid + 1, high);
            }else{
                return mid;
            }
        }
        return -(low + 1);
    }
}
