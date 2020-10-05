/*
 * 8.11 Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class Coins {
    public static int change(int amount){
        int[] denoms = {25, 10, 5, 1};
        int[][] cache = new int[amount + 1][denoms.length];
        return change(amount, denoms, 0, cache);
    }

    private static int change(int amount, int[] denoms, int index, int[][] cache){
        if(cache[amount][index] > 0){
            return cache[amount][index];
        }
        if(index == 3){
            return 1;
        }

        int ways = 0;
        int denom = denoms[index];
        for(int i = 0; i * denom <= amount; i++){
            ways += change(amount - i * denom, denoms, index + 1, cache);
        }
        cache[amount][index] = ways;
        return ways;
    }
}
