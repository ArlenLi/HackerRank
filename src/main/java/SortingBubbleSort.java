public class SortingBubbleSort {
    public static void countSwaps(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    count++;
                }
            }
        }

        System.out.printf("Array is sorted in %d swaps.%n", count);
        System.out.printf("First Element: %d%n", a[0]);
        System.out.printf("Last Element: %d%n", a[a.length - 1]);
    }

    private static void swap(int firstIndex, int secondIndex, int[] arr){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
