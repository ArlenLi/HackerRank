import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length <= 2 || nums[0] > 0 || nums[nums.length - 1] < 0){
            return result;
        }

        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int thirdIndex = Arrays.binarySearch(nums, j + 1, nums.length, 0 - (nums[i] + nums[j]));

                if (thirdIndex > 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[thirdIndex]);
                    result.add(list);
                }
            }
        }

        return result;
    }
}
