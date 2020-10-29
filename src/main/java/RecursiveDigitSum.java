public class RecursiveDigitSum {
    public static int superDigit(String n, int k){
        while(n.length() != 1){
            n = calculateSum(n);
        }

        n = String.valueOf(Integer.parseInt(n) * k);

        while(n.length() != 1){
            n = calculateSum(n);
        }
        return Integer.parseInt(n);
    }

    private static String calculateSum(String n){
        long sum = 0;
        for(int i = 0; i < n.length(); i++){
            sum += Character.getNumericValue(n.charAt(i));
        }
        return String.valueOf(sum);
    }

}
