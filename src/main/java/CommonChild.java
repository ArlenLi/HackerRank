import java.util.Arrays;

public class CommonChild {
    public static int commonChild(String s1, String s2){
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < table.length; i++)
            for(int j = 0; j < table[0].length; j++){
                if(i == 0 || j == 0){
                    table[i][j] = 0;
                }else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else{
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        return table[s1.length()][s2.length()];
    }
}
