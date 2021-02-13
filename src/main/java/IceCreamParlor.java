import java.util.Hashtable;

public class IceCreamParlor {
    static void whatFlavors(int[] cost, int money){
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();

        for(int i = 0; i < cost.length; i++){
            int remainder = money - cost[i];
            if(hashTable.containsKey(remainder)){
                System.out.println((hashTable.get(remainder) + 1) + " " + (i + 1));
                break;
            }else{
                hashTable.put(cost[i], i);
            }
        }
    }
}
