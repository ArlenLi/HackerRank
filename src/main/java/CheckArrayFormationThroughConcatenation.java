import java.util.HashMap;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces){
        HashMap<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < pieces.length; i++){
            map.put(pieces[i][0], pieces[i]);
        }

        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                return false;
            }
            int[] nums = map.get(arr[i]);
            for(int j = 1; j < nums.length; j++){
                if(nums[j] != arr[++i]){
                    return false;
                }
            }
        }
        return true;
    }
}
