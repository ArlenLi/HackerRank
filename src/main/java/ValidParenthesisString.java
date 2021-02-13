public class ValidParenthesisString {
    public boolean checkValidString(String s){
        return checkValidString(0, 0, 0, s);
    }

    private boolean checkValidString(int left, int right, int index, String s){
        if(right > left){
            return false;
        } else if(index == s.length()){
            return left == right;
        } else if(s.charAt(index) == '('){
            return checkValidString(left + 1, right, index + 1, s);
        } else if(s.charAt(index) == ')'){
            return checkValidString(left, right + 1, index + 1, s);
        } else{
            return checkValidString(left, right, index + 1, s)
                    || checkValidString(left + 1, right, index + 1, s)
                    || checkValidString(left, right + 1, index + 1, s);
        }
    }
}
