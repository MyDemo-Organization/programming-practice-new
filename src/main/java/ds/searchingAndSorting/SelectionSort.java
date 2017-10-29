package ds.searchingAndSorting;

import static utility.Functions.swap;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
public class SelectionSort {

    public static void selectionSort(final int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            final int minIndex = getMinIndex(a, i + 1, i);

            if (minIndex != i) {
                swap(a, minIndex, i);
            }
        }
    }

    private static int getMinIndex(final int[] a, final int currentIndex, int minSoFarIndex) {
        // Base case
        if (currentIndex >= a.length) {
            return minSoFarIndex;
        }

        if (a[currentIndex] < a[minSoFarIndex]) {
            minSoFarIndex = currentIndex;
        }
        return getMinIndex(a, currentIndex + 1, minSoFarIndex);
    }
}
