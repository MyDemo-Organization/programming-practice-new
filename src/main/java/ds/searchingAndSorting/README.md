# Searching and Sorting
---

## Sorting

### Bubble Sort

| Best Case     | Worst Case     |
| :------------- | :------------- |
| O(N) <- Already sorted | O(N^2) <- Reverse Sorted |

- The idea is that in each iteration the largest number bubbles out at the end.
  - So in each iteration we keep on skipping the last bubble out number while sorting.
```java
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
```

### Insertion Sort

| Best Case     | Worst Case     |
| :------------- | :------------- |
| O(N) <- Already sorted | O(N^2) <- Reverse Sorted |

- Ideas is to keep inserting the new key at the right place in the already sorted number.
  - So in each iteration the array is divided into the sorted and unsorted arrays.

    ```java
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
    ```

### Selection Sort

| Best Case     | Worst Case     |
| :------------- | :------------- |
| O(N^2) | O(N^2) |

- Idea is to select the minimum of all in the unsorted portion of the array and put it in the sorted portion of the array.
- It is going to have the same time complexity no matter if the array is sorted or not.

  ```Java
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
  ```


## Merge Sort
- Time complexity

| Best Case     | Worst Case     |
| :------------- | :------------- |
| O(N log N) | O(N log N) |
- Simple funda
  - divide sort and merge :smile:
```Java
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
```
