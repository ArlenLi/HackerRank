/*
 * 8.7 Permutations without Dups: Write a method to compute all permutations of a string of unique
 * characters.
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDup {
    public static List<String> algo(String input){
        List<String> result = new ArrayList<String>();
        if(input.length() == 0){
            result.add("");
            return result;
        }else{
            for(int i = 0; i < input.length(); i++){
                String leftString = input.substring(0, i);
                String rightString = input.substring(i + 1);
                List<String> permutationsOfSubstring = algo(leftString + rightString);

                for (String permutationOfSubString:
                        permutationsOfSubstring) {
                    result.add(input.charAt(i) + permutationOfSubString);
                }
            }
        }
        return result;
    }
}
