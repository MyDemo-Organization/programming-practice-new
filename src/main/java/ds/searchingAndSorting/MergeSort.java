package ds.searchingAndSorting;

import java.util.Arrays;

/**
 * Problem Statement: "MergeSort"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
public class MergeSort {

    public static void mergeSort(final int[] a) {
         mergeSortUtil(a, 0, a.length -1);
    }

    public static void mergeSortUtil(final int[] a, final int left, final  int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSortUtil(a, left, middle);
        mergeSortUtil(a, middle + 1, right);
        sortedMerge(a, left, middle, right);
    }

    // leftArray[] -> a[left...mid] (both inclusive) => length = mid -left + 1
    // rightArray[] -> a[mid + 1..right] (both inclusive) => length = right - (mid+1) - 1 = right - mid
    public static void sortedMerge(final int[] a, final int left, final int middle, final int right) {
        // NOTE: Arrays util skips the lats element : ) Os last index is not inclusive
        final int[] sortedLeftArray = Arrays.copyOfRange(a, left, middle + 1);
        final int[] sortedRightArray = Arrays.copyOfRange(a, middle+1, right + 1);


        // NOTE: Make sure your merged index starts from the 'left'
        int mergedArrayIndex = left;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        while (leftArrayIndex < sortedLeftArray.length &&
                rightArrayIndex < sortedRightArray.length) {
            if (sortedLeftArray[leftArrayIndex] <= sortedRightArray[rightArrayIndex]) {
                a[mergedArrayIndex++] = sortedLeftArray[leftArrayIndex++];
            } else {
                a[mergedArrayIndex++] = sortedRightArray[rightArrayIndex++];
            }
        }

        // take care of the remaining elements in the right and left sorted arrays;

        while (leftArrayIndex < sortedLeftArray.length) {
            a[mergedArrayIndex++] = sortedLeftArray[leftArrayIndex++];
        }

        while (rightArrayIndex < sortedRightArray.length) {
            a[mergedArrayIndex++] = sortedRightArray[rightArrayIndex++];
        }
    }
}
