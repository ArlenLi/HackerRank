import java.util.Arrays;

public class LongestStableMarketPeriod {
    public static int[] longestStableMarketPriod(int[] input, int variance){
        int longest = 0;
        int longestStart = 0;
        int longestEnd = 0;
        int currentStart = 0;
        int currentEnd = 0;

        for(int i = 1; i < input.length; i++){
            if(Math.abs(input[i] - input[i - 1]) <= variance){
                currentEnd++;
            }else{
                if (currentEnd - currentStart + 1 > longest) {
                    longest = currentEnd - currentStart + 1;
                    longestStart = currentStart;
                    longestEnd = currentEnd;
                }
                currentStart = i;
                currentEnd = i;
            }
        }

        if(currentEnd - currentStart + 1 > longest){
            longestStart = currentStart;
            longestEnd = currentEnd;
        }

        return Arrays.copyOfRange(input, longestStart, longestEnd + 1);
    }
}
