import java.util.*;

public class RoadsAndLibraries {
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] roads){
        if(c_lib <= c_road){
            return (long)c_lib * n;
        }


        Node[] cities = new Node[n];

        for(int i = 0; i < cities.length; i++){
            cities[i] = new Node();
        }

        for(int[] road : roads){
            cities[road[0] - 1].adjacentNodes.add(cities[road[1] - 1]);
            cities[road[1] - 1].adjacentNodes.add(cities[road[0] - 1]);
        }

        long sum = 0;
        for(Node city : cities){
            if(!city.visited){
                long count = 0;
                Queue<Node> queue = new LinkedList<>();
                city.visited = true;
                queue.add(city);
                while(!queue.isEmpty()){
                    Node queueNode = queue.poll();
                    count++;
                    for(Node adjacentNode : queueNode.adjacentNodes){
                        if(adjacentNode.visited == false){
                            adjacentNode.visited = true;
                            queue.add(adjacentNode);
                        }
                    }
                }
                sum += c_road * (count - 1) + c_lib;
            }
        }

        return sum;
    }

    static class Node{
        public boolean visited;
        public List<Node> adjacentNodes;

        public Node(){
            adjacentNodes = new ArrayList<>();
        }
    }
}
