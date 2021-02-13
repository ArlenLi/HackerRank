import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results;
    }

    private void permute(int[] nums, int firstIndex, List<List<Integer>> results){
        if(firstIndex == nums.length - 1){
            List<Integer> result = new ArrayList<>();
            for(int num: nums){
                result.add(num);
            }
            results.add(result);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = firstIndex; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                swap(firstIndex, i, nums);
                permute(nums, firstIndex + 1, results);
                swap(firstIndex, i, nums);
            }
        }
    }

    private void swap(int firstIndex, int secondIndex, int[] arr){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
