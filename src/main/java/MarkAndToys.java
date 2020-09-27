import java.util.Arrays;

public class MarkAndToys {
    public static int maximumToys(int[] prices, int k){
        Arrays.sort(prices);

        int maximumToys = 0;
        int sum = 0;
        for (int price : prices) {
            sum += price;
            if (sum < k) {
                maximumToys++;
            } else {
                break;
            }
        }
        return maximumToys;
    }
}
