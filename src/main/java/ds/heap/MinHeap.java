package ds.heap;

import lombok.Getter;
import lombok.NonNull;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/27/17
 */
@Getter
public class MinHeap {
    private int[] heapArray;
    private int capacity;
    private int size;

    public MinHeap(@NonNull final int capacity) {
        heapArray = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    // Time Complexity : O(log N)
    private void minBubbleDown(final int index) {
        // base case
        if (index >= size) {
            return;
        }

        final int left = getLeft(index);
        final int right = getRight(index);
        int min = index;

        // get the minimum of index, left and right
        if (left < size && heapArray[left] < heapArray[min]) {
            min = left;
        }

        if (right < size && heapArray[right] < heapArray[min]) {
            min = right;
        }

        // check if the index has changed
        if (min != index) {
            swap(index, min);
            minBubbleDown(min);
        }
    }

    // Time Complexity : O(log N)
    private void minBubbleUp(final int index) {
        // Base case: we have to stop at root
        if (index <= 0 || index >= size) {
            return;
        }

        final int parent = getParent(index);

        // check if parent is smaller
        if (heapArray[parent] > heapArray[index]) {
            swap(index, parent);
            minBubbleUp(parent);
        }
    }

    // Pre: index > 0
    private int getParent(final int index) {
        return (index - 1 )  /  2;
    }

    private int getLeft(final int index) {
        return 2 * index + 1;
    }

    private int getRight(final int index) {
        return 2 * index + 2;
    }

    private void swap(final int firstIndex, final int secondIndex) {
        final int temp = heapArray[firstIndex];
        heapArray[firstIndex] = heapArray[secondIndex];
        heapArray[secondIndex] = temp;
    }

}
