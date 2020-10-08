/*
10.1 Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.
 */
public class SortedMessage {
    public static int[] algo(int[] a, int[] b){
        int[] result = new int[a.length];
        int index = 0;
        int indexOfA = 0;
        int indexOfB = 0;

        while(indexOfB < b.length){
            result[index++] = a[indexOfA] < b[indexOfB] ? a[indexOfA++] : b[indexOfB++];
        }

        while(indexOfA < a.length && index < result.length){
            result[index++] = a[indexOfA++];
        }
        return result;
    }

    public static int[] algo(int[] a, int[] b, int lastIndexOfA, int lastIndexOfB){
        int lastIndex = lastIndexOfA + lastIndexOfB + 1;
        while(lastIndexOfB >= 0){
            a[lastIndex--] = a[lastIndexOfA] > b[lastIndexOfB]? a[lastIndexOfA--] : b[lastIndexOfB--];
        }
        return a;
    }
}
