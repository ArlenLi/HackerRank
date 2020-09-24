public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    private static final char Uphill = 'U';
    private static final char Downhill = 'D';

    public static int countingValleys(int steps, String path) {
        int uSteps = 0;
        int dSteps = 0;
        int valleyNum = 0;
        for (char step:path.toCharArray()
             ) {
            if(step == Downhill && uSteps == 0 && dSteps == 0)
            {
                valleyNum++;
            }
            if(step == Downhill){
                dSteps++;
            }else{
                uSteps++;
            }
            if(uSteps == dSteps){
                uSteps = 0;
                dSteps = 0;
            }
        }
        return valleyNum;
    }
}
