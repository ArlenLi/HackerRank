import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KthSmallestInstructions {
    public static String kthSmallestPath(int[] destination, int k){
        int[][] pathCountTable = new int[destination[0] + 1][destination[1] + 1];
        for(int i = pathCountTable.length - 1; i >= 0; i--)
            for(int j = pathCountTable[0].length - 1; j >= 0; j--){
                if(i == pathCountTable.length - 1 && j == pathCountTable[0].length - 1){
                    pathCountTable[i][j] = 1;
                }else if(i == pathCountTable.length - 1){
                    pathCountTable[i][j] = pathCountTable[i][j + 1];
                }else if(j == pathCountTable[0].length - 1){
                    pathCountTable[i][j] = pathCountTable[i + 1][j];
                }else{
                    pathCountTable[i][j] = pathCountTable[i + 1][j] + pathCountTable[i][j + 1];
                }
            }

        StringBuilder sb = new StringBuilder();
        findKthSmallestInstructions(0, 0, pathCountTable, k, sb);
        return sb.toString();
    }

    private static void findKthSmallestInstructions(int x, int y, int[][] pathCountTable, int k, StringBuilder sb){
        if(x == pathCountTable.length - 1 && y == pathCountTable[0].length - 1){
            return;
        }
        if(x == pathCountTable.length - 1){
            sb.append('H');
            y++;
        }else if(y == pathCountTable[0].length - 1){
            sb.append('V');
            x++;
        }else{
            if(k <= pathCountTable[x][y + 1]){
                sb.append('H');
                y++;
            }else{
                sb.append('V');
                k= k - pathCountTable[x][y + 1];
                x++;
            }
        }
        findKthSmallestInstructions(x, y, pathCountTable, k, sb);
    }
}
