public class RotLeft {
    public static int[] rotLeft(int[] a, int d){
        int remainder = d % a.length;
        int[] result = new int[a.length];

        for(int i = 0; i < a.length; i++){
           result[(i + a.length - remainder) % a.length] = a[i];
        }
        return result;
    }
}
