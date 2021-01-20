public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s){
        int currentLongest = 0;
        int[] coordinates = new int[2];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = dp.length - 1; i >= 0; i--)
            for(int j = 0; j < dp[0].length; j++){
                if(i > j){
                    dp[i][j] = false;
                }else if(i == j){
                    dp[i][j] = true;
                }else if(j - i == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(dp[i + 1][j - 1]){
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]){
                    if(j - i + 1 > currentLongest){
                        currentLongest = j - i + 1;
                        coordinates[0] = i;
                        coordinates[1] = j;
                    }
                }
            }

        return s.substring(coordinates[0], coordinates[1] + 1);
    }
}
