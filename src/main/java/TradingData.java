import java.util.Arrays;

public class TradingData {
    public static int[] tradingData(int[] systemA, int[] systemB){
        Arrays.sort(systemA);
        int[] result = new int[systemB.length];
        for(int i = 0; i < systemB.length; i++){
            result[i] = binarySearch(systemA, systemB[i]);
        }
        return result;
    }

    private static int binarySearch(int[] systemA, int val){
        int searchResult = Arrays.binarySearch(systemA, val);
        if (searchResult >= 0) {
            searchResult++;
            while(searchResult < systemA.length && systemA[searchResult] == val){
                searchResult++;
            }
        }else{
            searchResult = -searchResult - 1;
        }
        return searchResult;
    }
}
