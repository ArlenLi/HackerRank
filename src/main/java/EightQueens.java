import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    private static final int GRID_SIZE = 8;
    public static List<int[]> EightQueensAlgo(){
        int[] columns = new int[GRID_SIZE];
        List<int[]> results = new ArrayList<int[]>();

        place(columns, 0, results);
        for(int i = 0; i < results.size(); i++){
            boolean[][] board = new boolean[GRID_SIZE][GRID_SIZE];
            for(int j = 0; j < results.get(i).length; j++){
                board[j][results.get(i)[j]] = true;
            }

            for(int row = 0; row < GRID_SIZE; row++){
                for(int column = 0; column < GRID_SIZE; column++){
                    if(board[row][column]) {
                        System.out.print("Q");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        return results;
    }

    private static void place(int[] columns, int row, List<int[]> results){
        if(row == 8){
            results.add(columns.clone());
        }else{
            for(int columnIndex = 0; columnIndex < GRID_SIZE; columnIndex++){
                if(isColumnIndexValid(columns, row, columnIndex)){
                    columns[row] = columnIndex;
                    place(columns, row + 1, results);
                }
            }
        }
    }

    private static boolean isColumnIndexValid(int[] columns, int row, int column){
        for(int rowIndex = 0; rowIndex < row; rowIndex++){
            if(columns[rowIndex] == column){
                return false;
            }else if(Math.abs(columns[rowIndex] - column) == row - rowIndex){
                return false;
            }
        }
        return true;
    }
}
