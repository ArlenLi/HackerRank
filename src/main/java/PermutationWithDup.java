/*
    8.8 Permutations with Dups: Write a method to compute all permutations of a string whose characters
    are not necessarily unique. The list of permutations should not have duplicates.
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationWithDup {
    public static List<String> algo(String input){
        List<String> result = new ArrayList<String>();
        if(input.length() == 0)
        {
            result.add(input);
        }else{
            char firstChar = input.charAt(0);
            String substring = input.substring(1);
            List<String> permutationsOfSubstring = algo(substring);
            if(substring.indexOf(firstChar) == -1){
                for(String permutationOfSubstring :
                permutationsOfSubstring){
                    for(int i = 0; i <= permutationOfSubstring.length(); i++){
                        StringBuilder sb = new StringBuilder(permutationOfSubstring);
                        sb.insert(i, firstChar);
                        result.add(sb.toString());
                    }
                }
            }else{
                result = permutationsOfSubstring;
            }
        }
        return result;
    }
}
