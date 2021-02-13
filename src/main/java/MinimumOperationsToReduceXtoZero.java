import java.util.Arrays;
import java.util.HashMap;

public class MinimumOperationsToReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        int target = totalSum - x;

        if(target == 0){
            return nums.length;
        }

        int longestSubArrayLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int presum = sum - target;
            if(map.containsKey(presum)){
                int presumIndex = map.get(presum);
                int subArrayLength = i - presumIndex;
                if(subArrayLength > longestSubArrayLength){
                    longestSubArrayLength = subArrayLength;
                }
            }

            map.put(sum, i);
        }
        return longestSubArrayLength == 0 ? -1 : nums.length - longestSubArrayLength;
    }
}
