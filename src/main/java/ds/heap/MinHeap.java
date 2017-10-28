package ds.heap;

import ds.binaryTree.BinaryTreeNode;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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

    public int getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is Empty!");
        }
        return heapArray[0];
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is Empty!");
        }

        final int lastElement = heapArray[size-1];
        final int minElement = heapArray[0];
        heapArray[0] = lastElement;
        minBubbleDown(0);
        size--;
        return minElement;
    }

    public int insertKey(final int key) {
        if (size == capacity) {
            throw new IllegalArgumentException("Heap is already full!");
        }

        heapArray[size] = key;
        size++; // we have added size here to make sure logic stays the correct
        minBubbleUp(size - 1);
        return key;
    }

    public void deleteKey(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index not valid!");
        }

        decreaseKey(index, Integer.MIN_VALUE);

        // now the value at the root is the value to be removed
        extractMin();
    }

    private void decreaseKey(final int index, final int smallerValue) {
        if (heapArray[index] <= smallerValue) {
            throw new IllegalArgumentException("Value passed is not smaller!");
        }

        heapArray[index] = smallerValue;
        minBubbleUp(index);
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

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    private BinaryTreeNode getBinaryTree() {
        if (size == 0) {
            return null;
        }

        final BinaryTreeNode root = new BinaryTreeNode(heapArray[0]);

        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);

        int currentIndex = 0;
        currentIndex ++;
        while (currentIndex < size && !queue.isEmpty()) {
            int currentLevelSize = queue.size();

            while (currentIndex < size && currentLevelSize > 0) {
                final BinaryTreeNode currentNode = queue.poll();
                if (currentIndex < size) {
                    final BinaryTreeNode leftNode = new BinaryTreeNode(heapArray[currentIndex++]);
                    currentNode.setLeft(leftNode);
                    queue.add(leftNode);
                }
                if (currentIndex < size) {
                    final BinaryTreeNode rightNode = new BinaryTreeNode(heapArray[currentIndex++]);
                    currentNode.setRight(rightNode);
                    queue.add(rightNode);
                }
            }
        }
        return root;
    }

    // creates a sample heap
    public void createSampleHeap() {
        Random random = new Random(909768973);
        int i = 0;
        while (i < capacity) {
            final int randomNumber = random.nextInt(100);
            System.out.println("Inserting " + randomNumber);
            insertKey(randomNumber);
            System.out.println("Heap after Insertion....");
            System.out.println(this);
            i++;
        }
    }

    @Override
    public String toString() {
        getBinaryTree().printTree();
        return ArrayUtils.toString(heapArray);
    }
}
