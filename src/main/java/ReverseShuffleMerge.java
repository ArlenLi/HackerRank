public class ReverseShuffleMerge {
    public static String reverseShuffleMerge(String s){
        int[] charCountInOriginalString = new int[26];
        int[] charCountInResult = new int[26];

        for(int i = 0; i < s.length(); i++){
            charCountInOriginalString[s.charAt(i) - 97]++;
        }

        for(int i = 0; i < charCountInOriginalString.length; i++){
            charCountInResult[i] = charCountInOriginalString[i] / 2;
        }

        char[] result = new char[s.length() / 2];
        int index = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char currentChar = s.charAt(i);
            if(charCountInResult[currentChar - 97] > 0){
                while(index - 1 >= 0
                && currentChar < result[index - 1]
                && charCountInOriginalString[result[index - 1] - 97] >= charCountInResult[result[index - 1] - 97] + 1){
                    charCountInResult[result[--index] - 97]++;
                }
                result[index++] = currentChar;
                charCountInResult[currentChar - 97]--;
            }
            charCountInOriginalString[currentChar - 97]--;
        }

        return new String(result);
    }
}
