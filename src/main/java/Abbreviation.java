import java.util.HashMap;

public class Abbreviation {
    // Complete the abbreviation function below.
    public static String abbreviation(String a, String b) {
        HashMap<String, Boolean> cache = new HashMap<>();
        if(algo(a, b, a.length() - 1, b.length() - 1, cache)){
            return "YES";
        }else{
            return "NO";
        }
    }

    private static boolean algo(String a, String b, int indexOfA, int indexOfB, HashMap<String, Boolean> cache){
        if(indexOfA < indexOfB){
            return false;
        }
        if(indexOfA == 0 && indexOfB == 0){
            return ((a.charAt(0) <= 90 && a.charAt(0) == b.charAt(0))
                    || (a.charAt(0) >= 97 && a.charAt(0) -32 == b.charAt(0)));
        }
        if(indexOfA >= 0 && indexOfB < 0){
            while(indexOfA >= 0){
                if(a.charAt(indexOfA) <=90){
                    return false;
                }
                indexOfA--;
            }
            return true;
        }

        String key = String.format("%d%d", indexOfA, indexOfB);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        boolean result = false;
        char charOfA = a.charAt(indexOfA);
        char charOfB = b.charAt(indexOfB);

        if(charOfA <= 90 && charOfA == charOfB){
            result =  algo(a, b, indexOfA - 1, indexOfB - 1, cache);
        } else if(charOfA <= 90){
            result =  false;
        }else if(charOfA >=97 && charOfA - 32 == charOfB){
            result =  algo(a, b, indexOfA - 1, indexOfB, cache) ||
                    algo(a, b, indexOfA - 1, indexOfB - 1, cache);
        }else{
            result =  algo(a, b, indexOfA - 1, indexOfB, cache);
        }

        cache.put(key, result);
        return result;
    }

}
