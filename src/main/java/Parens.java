import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Parens {
    public static List<String> algo(int input){
        List<String> result = new ArrayList<String>();
        if(input < 0){
            throw new IllegalArgumentException();
        }else if(input == 0){
            return result;
        }else {
            char[] arr = new char[input * 2];
            addParent(result, input, input, arr, 0);
        }
        return result;
    }

    private static void addParent(List<String> result, int remainingLeft, int remainingRight, char[] arr, int index){
        if(remainingLeft < 0 || remainingRight < 0 || remainingRight < remainingLeft) {
            return;
        }else if(remainingLeft == 0 && remainingRight == 0){
            result.add(new String(arr));
        }else{
            arr[index] = '(';
            addParent(result, remainingLeft - 1, remainingRight, arr, index + 1);

            arr[index] = ')';
            addParent(result, remainingLeft, remainingRight - 1, arr, index + 1);
        }
    }

    public static List<String> algo1(int input){
        List<String> result = new ArrayList<>();
        if(input < 0){
            throw new IllegalArgumentException();
        }else if(input == 0){
            return result;
        }else{
            StringBuilder sb = new StringBuilder();
            addParent(result, sb, input, input);
            return result;
        }
    }

    private static void addParent(List<String> result, StringBuilder sb, int leftRemaining, int rightRemaining){
        if(leftRemaining == 0 && rightRemaining == 0){
            result.add(sb.toString());
            return;
        }

        if(leftRemaining > 0){
            sb.append('(');
            addParent(result, sb, leftRemaining - 1, rightRemaining);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(rightRemaining > 0 && rightRemaining > leftRemaining){
            sb.append(')');
            addParent(result, sb, leftRemaining, rightRemaining - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
