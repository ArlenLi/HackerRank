public class CreateSortedArrayThroughInstructions {
    public int createSortedArray(int[] instructions) {
        Instruction[] instructionArr = new Instruction[instructions.length];

        mergeSort(instructions ,instructionArr, 0, instructionArr.length - 1);

        long sum = 0;
        for(int i = 0; i < instructionArr.length; i++){
            sum += Math.min(instructionArr[i].lessThanNum, instructionArr[i].greaterThanNum);
        }
        return (int)(sum % 1000000007);
    }

    private void mergeSort(int[] original, Instruction[] arr, int low, int high){
        if(low > high){
            return;
        }
        if(low == high){
            arr[low] = new Instruction(original[low]);
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(original, arr, low, mid);
        mergeSort(original, arr, mid + 1, high);

        int leftIndex = low;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        Instruction[] temp = new Instruction[high - low + 1];

        while(leftIndex <= mid && rightIndex <= high){
            if(arr[rightIndex].val <= arr[leftIndex].val){
                temp[tempIndex] = arr[rightIndex++];
                temp[tempIndex].lessThanNum += leftIndex - low;
                int j = leftIndex;
                while(j <= mid && arr[j].val == temp[tempIndex].val){
                    j++;
                }
                temp[tempIndex].greaterThanNum += mid - j + 1;
            }else{
                temp[tempIndex] = arr[leftIndex++];
            }
            tempIndex++;
        }

        while(leftIndex <= mid){
            temp[tempIndex++] = arr[leftIndex++];
        }

        while(rightIndex <= high){
            temp[tempIndex] = arr[rightIndex++];
            temp[tempIndex].lessThanNum += mid - low + 1;
            tempIndex++;
        }

        for(int i = 0; i < temp.length; i++){
            arr[i + low] = temp[i];
        }
    }


    class Instruction{
        int val;
        int lessThanNum;
        int greaterThanNum;

        public Instruction(int val){
            this.val = val;
        }
    }
}
