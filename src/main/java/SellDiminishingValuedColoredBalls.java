import java.util.Arrays;

public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        long maxProfit = 0;
        Arrays.sort(inventory);
        int count = 1;

        for(int i = inventory.length - 1; i >= 0; i--){
            int low = 0;
            int high = inventory[i];
            if(i == 0){
                low = 0;
            }else{
                low = inventory[i - 1];
            }

            if(high > low){
                if(count * (high - low) <= orders){
                    maxProfit += count * sum(high, low);
                    orders -= count * (high - low);
                }else{
                    int quotient = orders / count;
                    int remainder = orders % count;
                    if(quotient > 0){
                        maxProfit += count * sum(high, high - quotient);
                    }
                    maxProfit += ((long)remainder * (high - quotient)) % 1000000007;
                    break;
                }
            }
            count++;
        }

        return (int)(maxProfit % 1000000007);
    }

    private long sum(long high, long low){
        long result = (high + 1) * high / 2- (low + 1) * low / 2;
        return result % 1000000007;
    }
}
