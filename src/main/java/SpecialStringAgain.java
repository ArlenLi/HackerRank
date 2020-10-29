public class SpecialStringAgain {
    public static long substrCount(int n, String s){
        int count = s.length();
        for(int i = 0; i < s.length() - 1; i++)
        {
            char currentChar = s.charAt(i);
            int j = i + 1;
            boolean hasMetDifferentChar = false;
            int sameCharsLengthBeforeADifferentChar = 1;

            while(j < s.length())
            {
                if(!hasMetDifferentChar) {
                    if(s.charAt(j) == currentChar) {
                        count++;
                        sameCharsLengthBeforeADifferentChar++;
                    }else{
                        hasMetDifferentChar = true;
                    }
                }else{
                    if(currentChar == s.charAt(j)){
                        sameCharsLengthBeforeADifferentChar--;
                        if(sameCharsLengthBeforeADifferentChar == 0){
                            count++;
                            break;
                        }
                    }else{
                        break;
                    }
                }
                j++;
            }
        }
        return count;
    }
}
