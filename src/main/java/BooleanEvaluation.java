/*
8.14 Boolean Evaluation: Given a boolean expression consisting of the symbols e (false), 1 (true), &
(AND), I (OR), and" (XOR), and a desired boolean result value result, implement a function to
count the number of ways of parenthesizing the expression such that it evaluates to result.
EXAMPLE
countEval("1"eleI1"J false) -) 2
countEval("e&e&e&l"lle"J true) -) 1e
 */
import java.util.HashMap;

public class BooleanEvaluation {
    public static int countParenthesizing(String input, boolean result){
        HashMap<String, Integer> memo = new HashMap<>();

        return countParenthesizing(input, result, memo);
    }

    private static int countParenthesizing(String input, boolean result, HashMap<String, Integer> memo){
        if(input.length() == 0){
            return 0;
        }

        if(input.length() == 1){
            return stringToBool(input) == result? 1: 0;
        }

        if(memo.containsKey(input + result)){
            return memo.get(input + result);
        }

        int count = 0;
        for(int i = 1; i < input.length(); i = i + 2){
            if(input.charAt(i) == '|'){
                if(result == true){
                    int leftTrue = countParenthesizing(input.substring(0, i), true, memo);
                    int leftFalse = countParenthesizing(input.substring(0, i), false, memo);
                    int rightTrue = countParenthesizing(input.substring(i + 1), true, memo);
                    int rightFalse = countParenthesizing(input.substring(i + 1), false, memo);

                    count += leftTrue * rightFalse + leftTrue * rightTrue + leftFalse * rightTrue;
                }else{
                    int leftFalse = countParenthesizing(input.substring(0,i), false, memo);
                    int rightFalse = countParenthesizing(input.substring(i + 1), false, memo);

                    count += leftFalse * rightFalse;
                }
            } else if(input.charAt(i) == '&'){
                if(result == true){
                    int leftTrue = countParenthesizing(input.substring(0,i), true, memo);
                    int rightTrue = countParenthesizing(input.substring(i + 1), true, memo);

                    count += leftTrue * rightTrue;
                }else{
                    int leftTrue = countParenthesizing(input.substring(0, i), true, memo);
                    int leftFalse = countParenthesizing(input.substring(0, i), false, memo);
                    int rightTrue = countParenthesizing(input.substring(i + 1), true, memo);
                    int rightFalse = countParenthesizing(input.substring(i + 1), false, memo);

                    count += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }else if(input.charAt(i) == '^'){
                int leftTrue = countParenthesizing(input.substring(0, i), true, memo);
                int leftFalse = countParenthesizing(input.substring(0, i), false, memo);
                int rightTrue = countParenthesizing(input.substring(i + 1), true, memo);
                int rightFalse = countParenthesizing(input.substring(i + 1), false, memo);

                if(result == true){
                    count += leftTrue * rightFalse + leftFalse * rightTrue;
                }else{
                    count += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }

        memo.put(input + result, count);
        return count;
    }
    
    private static boolean stringToBool(String input){
        return input.equals("1");
    }
}
