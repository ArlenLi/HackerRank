public class RepeatedString {
    public static long repeatedString(String s, long n){
        long numOfAInASingleString = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                numOfAInASingleString++;
            }
        }

        if(numOfAInASingleString == 0){
            return 0;
        }

        long remainder = n % (long)s.length();
        long numOfAInRemainder = 0;
        for(int i = 0; i < remainder; i++){
            if(s.charAt(i) == 'a'){
                numOfAInRemainder++;
            }
        }
        return (n / s.length() * numOfAInASingleString) + numOfAInRemainder;
    }
}
