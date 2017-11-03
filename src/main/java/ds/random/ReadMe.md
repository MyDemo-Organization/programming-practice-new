# Random Questions

- Search in sorted rotated array http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
- target sum in a sorted rotated array http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
- http://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
Formula is the only thing important here
```java
int next_val = curr_val - (cum_sum - arr[i-1])
                       + arr[i-1] * (n-1);
```
