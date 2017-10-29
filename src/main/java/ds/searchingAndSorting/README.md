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
