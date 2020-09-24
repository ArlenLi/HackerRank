public class JumpingOnClouds {
    public static int jumpingOnClouds(int[] c){
        int jumpCount = 0;
        int i = 0;
        while(i < c.length - 1){
            if( i + 2 < c.length && c[i + 2] == 0){
                i += 2;
            }
            else{
                i += 1;
            }
            jumpCount++;
        }
        return jumpCount;
    }
}
