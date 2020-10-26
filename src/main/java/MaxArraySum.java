import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MaxArraySum {
    public static int maxSubsetSum(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }

        int nonAdjacentSumMax = arr[0];
        int adjacentSumMax = arr[1];
        int globalMax = Math.max(nonAdjacentSumMax, adjacentSumMax);
        for(int i = 2; i < arr.length; i++){
            int currentNonAdjacentSum = Math.max(nonAdjacentSumMax + arr[i], arr[i]);
            if(currentNonAdjacentSum > globalMax){
                globalMax = currentNonAdjacentSum;
            }
            if(adjacentSumMax > nonAdjacentSumMax){
                nonAdjacentSumMax = adjacentSumMax;
            }
            adjacentSumMax = currentNonAdjacentSum;
        }

        return globalMax;
    }
}
