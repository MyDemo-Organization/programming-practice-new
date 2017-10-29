package ds.searchingAndSorting;

import org.apache.commons.lang3.ArrayUtils;
import utility.Functions;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
public class InsertionSort {

    public static void insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            insertKey(a, i -1, a[i]);
        }
    }

    // where key is to insertd in a a sorted array defiend as a[0..currentIndex
    public static void insertKey(int[] a, int currentIndex, int key) {

        // base case
        if (currentIndex < 0 || currentIndex >= a.length - 1|| a[currentIndex] <= key)
            return;

        // swap them
        Functions.swap(a, currentIndex, currentIndex + 1);
        insertKey(a, currentIndex - 1, key);
    }


}
