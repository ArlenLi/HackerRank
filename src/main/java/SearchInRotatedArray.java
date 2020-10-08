/*
10.3 Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
number of times, write code to find an element in the array. You may assume that the array was
originally sorted in increasing order.
EXAMPLE
Input:findSin{lS, 16, 19, 2a, 25, 1, 3,4,5,7, la, 14}
Output: 8 (the index of 5 in the array)
 */
public class SearchInRotatedArray {
    public static int algo(int[] nums, int target){
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int low, int high, int target){
        if(low > high){
            return - 1;
        }
        int mid = (low + high) / 2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > nums[low]){
            if(target >= nums[low] && target < nums[mid]){
                return binarySearch(nums, low, mid - 1, target);
            }else {
                return binarySearch(nums, mid + 1, high, target);
            }
        }else if(nums[mid] < nums[low]){
            if(target > nums[mid] && target <= nums[high]){
                return binarySearch(nums, mid + 1, high, target);
            }else{
                return binarySearch(nums, low, mid - 1, target);
            }
        }else{
            if(nums[mid] == nums[high]){
                int leftSearchResult = binarySearch(nums, low, mid - 1, target);
                if(leftSearchResult == -1){
                    return binarySearch(nums, mid + 1, high, target);
                } else{
                    return leftSearchResult;
                }
            }else{
                return binarySearch(nums, mid + 1, high, target);
            }
        }
    }


}
