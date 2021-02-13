import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public boolean visited;
    public List<GraphNode> adjacentNodes;

    public GraphNode(){
        adjacentNodes = new ArrayList<>();
    }
}
