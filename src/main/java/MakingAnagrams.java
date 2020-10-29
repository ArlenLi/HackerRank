public class MakingAnagrams {
    public static int makeAnagram(String a, String b){
        int[] charCounter = new int[26];

        for(int i = 0; i < a.length(); i++){
            charCounter[a.charAt(i) - 97]++;
        }

        for(int i = 0; i < b.length(); i++){
            charCounter[b.charAt(i) - 97]--;
        }

        int minimum = 0;
        for(int i = 0; i < charCounter.length; i++){
            if(charCounter[i] != 0){
                minimum += Math.abs(charCounter[i]);
            }
        }

        return minimum;
    }
}
