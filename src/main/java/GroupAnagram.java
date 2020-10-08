import java.util.*;

public class GroupAnagram {
    public static String[] algo(String[] arr){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : arr){
            String key = sortString(str);
            map.putIfAbsent(key, new ArrayList<>());
            ArrayList<String> arrList = map.get(key);
            arrList.add(str);
            map.put(key, arrList);
        }

        Iterator it = map.entrySet().iterator();
        int index = 0;
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            for(String str : (ArrayList<String>)entry.getValue()){
                arr[index++] = str;
            }
        }
        return arr;
    }

    private static String sortString(String input){
        char[] content = input.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
