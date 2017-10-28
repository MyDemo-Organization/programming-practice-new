package ds.heap;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/28/17
 */
public class SortTheAlmostSortedArray {

    // Time Complexity : O(N log k)
    // Space Complexity : O(K)
    public static void sortKSortedArray(final int[] kSortedArray,final int k) {

        // base case
        if (k < 2 || k >= kSortedArray.length) {
            return;
        }

        // STEP 1: create the heap with the k
        final MinHeap minHeap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            minHeap.insertKey(kSortedArray[i]);
        }

        // STEP 2: keep on removing the min element and keep addin the one more element
        for (int i = 0; i < kSortedArray.length - k; i++) {
            final int temp = kSortedArray[i+k];
            kSortedArray[i] = minHeap.extractMin();
            minHeap.insertKey(temp);
        }

        // STEP 3: remove the remaining elements from the heap
        for (int i = kSortedArray.length - k; i < kSortedArray.length; i++) {
            kSortedArray[i] = minHeap.extractMin();

        }
    }
}
