package ds.searchingAndSorting;

/**
 * Problem Statement: "Bubble Sort"
 *
 * Time Complexity : Best Case  : O(N) already sorted
 *                   Worst Case : O(N^2) reverse sorted
 *                   in place sorting
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/28/17
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] a) {
        boolean swappedInLastIteration = true;
        for (int i = 0; i < a.length - 1 && swappedInLastIteration == true; i++) {
            swappedInLastIteration = false;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j-1]) {
                    swap(a, j, j -1);
                    swappedInLastIteration = true;
                }
            }
        }
        return a;
    }

    private static void swap(final int[] a, final int indexOne, final int indexTwo) {
        final int temp = a[indexOne];
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    }
}
