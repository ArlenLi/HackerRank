import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BeautifulArrangement {
    private int counter = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        backtrack(visited, n);
        return counter;
    }

    private void backtrack(boolean[] visited, int index){
        if(index == 0){
            counter++;
            return;
        }

        for(int i = visited.length - 1; i >= 0; i--){
            if(!visited[i] &&((i + 1) % index == 0 || index % (i + 1) == 0)){
                visited[i] = true;
                backtrack(visited, index - 1);
                visited[i] = false;
            }
        }
    }
}
