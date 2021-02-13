import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean setFirstColumnToZeros = false;
        boolean setFirstRowToZeros = false;

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                setFirstColumnToZeros = true;
            }
        }

        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                setFirstRowToZeros = true;
            }
        }

        for(int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(matrix[i][0] != 0){
                        matrix[i][0] = 0;
                    }

                    if(matrix[0][j] != 0){
                        matrix[0][j] = 0;
                    }
                }
            }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(setFirstColumnToZeros){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(setFirstRowToZeros){
            Arrays.fill(matrix[0], 0);
        }
    }
}
