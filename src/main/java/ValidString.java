import java.util.Arrays;

public class ValidString {
    public static String isValid(String s){
        int[] charCounter = new int[26];

        for(int i = 0; i < s.length(); i++){
            charCounter[s.charAt(i) - 97]++;
        }

        Arrays.sort(charCounter);

        int minIndex = 0;
        int maxIndex = charCounter.length - 1;
        for(int i = 0; i < charCounter.length; i++){
            if(charCounter[i] != 0){
                minIndex = i;
                break;
            }
        }

        if(minIndex == maxIndex
                || (charCounter[minIndex] == 1 && charCounter[minIndex + 1] == charCounter[maxIndex])
                || (charCounter[minIndex] == charCounter[maxIndex - 1] && charCounter[maxIndex] - charCounter[minIndex] <= 1)){
            return "YES";
        }
        return "NO";
    }
}
