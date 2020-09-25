public class MinimumBribes {
    public static void minimumBribes(int[] q){
        int minimumBribes = 0;
        boolean isChaotic = false;
        for(int i = 0; i < q.length; i++){
            if((q[i] - i - 1) > 2) {
                isChaotic = true;
                break;
            }
            for(int j = Math.max(q[i] - 2, 0); j <= i - 1; j++){
                if(q[j] > q[i]){
                    minimumBribes++;
                }
            }
        }
        if(isChaotic){
            System.out.println("Too chaotic");
        }else{
            System.out.println(minimumBribes);
        }
    }
}
