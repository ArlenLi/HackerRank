import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (arr1, arr2) -> {
          return Integer.compare(arr1[0], arr2[0]);
        });

        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i + 1 < intervals.length && end >= intervals[i + 1][0]){
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}
