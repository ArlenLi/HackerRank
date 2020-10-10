public class SparseSearch {
    public static int algo(String[] arr, String target){
        return algo(arr, target, 0, arr.length - 1);
    }

    private static int algo(String[] arr, String target, int low, int high){
        int mid = (low + high) / 2;
        if(arr[mid].equals(target)){
            return mid;
        } else if(arr[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while(true){
                if(left < low && right > high){
                    return -1;
                }else if(left >= low && !arr[left].isEmpty()){
                    mid = left;
                    break;
                }else if(right <= high && !arr[right].isEmpty()){
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if(arr[mid].equals(target)){
            return mid;
        }else if(arr[mid].compareTo(target) > 0){
            return algo(arr, target, low, mid - 1);
        }else{
            return algo(arr, target, mid + 1, high);
        }
    }
}
