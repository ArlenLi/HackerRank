import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeVallidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> leftParentStack = new Stack<>();
        List<Integer> toBeRemovedRightParentList = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftParentStack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(leftParentStack.empty()){
                    toBeRemovedRightParentList.add(i);
                }else{
                    leftParentStack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        while(!leftParentStack.empty()){
            int toBeRemovedIndex = leftParentStack.pop();
            sb.replace(toBeRemovedIndex, toBeRemovedIndex + 1, " ");
        }

        for(int i = 0; i < toBeRemovedRightParentList.size(); i++){
            int toBeRemovedIndex = toBeRemovedRightParentList.get(i);
            sb.replace(toBeRemovedIndex, toBeRemovedIndex + 1, " ");
        }

        int j = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != ' '){
                sb.setCharAt(j++, sb.charAt(i));
            }
        }
        sb.delete(j, sb.length());
        return sb.toString();
    }
}
