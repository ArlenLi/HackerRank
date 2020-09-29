public class FraudulentActivityNotifications {
    public static int activityNotifications(int[] expenditure, int d){
        int notification = 0;
        int[] count = new int[201];
        for(int i = 0; i <= d - 1; i++){
            count[expenditure[i]]++;
        }
        for(int i = d; i < expenditure.length; i++){
            int doubleMedian = findDoubleMedian(count, d);
            if(expenditure[i] >= doubleMedian){
                notification++;
            }
            count[expenditure[i]]++;
            count[expenditure[i - d]]--;
        }
        return notification;
    }

    private static int findDoubleMedian(int[] count, int d){
        int elementsCount = 0;
        int doubleMedian = 0;
        if(d % 2 == 1){
            int medianIndex = d / 2;
            for(int i = 0; i < count.length; i++){
                elementsCount += count[i];
                if(elementsCount > medianIndex){
                    doubleMedian = i * 2;
                    break;
                }
            }
        }

        if(d % 2 == 0){
            int firstMedian = -1;
            int secondMedian = -1;
            int firstMedianIndex = (d - 1) / 2;
            int secondMedianIndex = firstMedianIndex + 1;
            for(int i = 0; i < count.length; i++){
                elementsCount += count[i];
                if(firstMedian == -1 && elementsCount > firstMedianIndex){
                    firstMedian = i;
                }

                if(elementsCount > secondMedianIndex){
                    secondMedian = i;
                    doubleMedian = firstMedian + secondMedian;
                    break;
                }
            }
        }
        return doubleMedian;
    }
}
