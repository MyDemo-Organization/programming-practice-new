# Binary Heap

## Problems

1. Implementation of Heap
  - Implementation
  - Why preferred over BST? (Theory)
    - Cases where BST is preferred over Heap?
  - Why preferred Implementation of Priority Queue?
- Heap Sort
- Sorting an almost sorted array (k-sorted array)  :small_red_triangle:
- Create a Binary tree from heap array :). Requested by me :)


## 1. Heap Implementation:
- **code** : `MinHeap.java`
- **Introduction** (MinHeap)
    - It is Binary tree having following properties;
      - Its a **complete binary tree**
        - Meaning nodes are added from left to right and all the *leaves* are at the **same level**
      - Key at the root is **smaller** than the both left and right node values && left and right subtrees are also *MinHeap*.
- **Implementation of MinHeap**
  - **Fields**
    - int[] harr; // Heap array:to store arrays
    - int capacity; // size of the arrays
    - int size; // current number of elements
  - **Expected methods:**
    - **Simple Getters:**
      - `getMin()` : returns the minimum of all the elements present without removing it. Kind of *peek()*.
      - `parent(index)` : returns the index of the parent for the given index.
      - `left(index)` : Returns the index of the left child node for the given parent index.
      - `right(index)` : returns the index of the right child for the given parent index
      - `swap(firstIndex, secondIndex)` : swaps the key values of the indices.
    - **Core methods:** (bubble up and bubble down are also called as heapify methods :)
      - `minBubbleUp(index)` : used to place the key at the right place after insertion
        - index is the index of the key which is to be placed the right place.
      - `minBubbleDown(index)` : used for deleting the node mostly.
        - assumes that lower tree is minHeap

    - **Derived Methods**
      - `extractMin()` : removes and returns the minimum of all values. (will need *bubble down*)
      - `insertKey(key)` : inserts the key in the heap. (will need *bubble up*)
      - `decreaseKey(index, lowerKeyValue)` : decreases the value of the key at the given index. (Make sure that it has the value less than before. Also will require bubble Up)
      - `deleteKey(index)` : will delete the ley at the given index.
        - Will use *decreaseKey()* and *extractMin()*.


## 3. Sorting an almost sorted array (k-sorted array)
- Code: `SortTheAlmostSortedArray.java`
- Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time.
- For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
- Idea is pretty simple use a k sized Heap :) thats it :)

```JAVA
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
```

## 4. Create a Binary tree from heap array :). Requested by me.

- Since Heap array is nothing but the level order traversal of a *complete binary tree* we can actually build a Binary tree from it :)
