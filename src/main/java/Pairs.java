import java.util.HashSet;
import java.util.Hashtable;

public class Pairs {
    public static int pairs(int k, int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            if(set.contains(value - k)){
                count++;
            }
            if(set.contains(value + k)){
                count++;
            }
            set.add(value);
        }
        return count;
    }
}
