# Dynamic Programming


## Introduction
- DP problems satisfy following 2 properties;
  - Overlapping Subproblems Property

## Problems to be solved

1. [Longest Increasing Subsequence](http://www.geeksforgeeks.org/longest-increasing-subsequence/)
- [Longest Palindromic Subsequence](http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/)
- [Longest Common Subsequence](http://www.geeksforgeeks.org/longest-common-subsequence/)
- [Maximum Sum Increasing sub sequence](http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/)
- [Edit Distance](http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/) :white_check_mark:
- [Min Cost Path](http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/)
- [Coin change](http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/)
- [Matrix Chain Multiplication](http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/)
- [Binomial Coefficient](http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/)
  - OR nCr
- [KnapSack Problem](http://www.geeksforgeeks.org/knapsack-problem/)
- [Subset Sum Problem](http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/)
- [Egg Dropping Puzzle](http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/)
- [Word Wrap](http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/)
- [Fibonacci](http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/)
- [Maximum sum rectangle in a 2D matrix](http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/)
- [number of ways to reach the given score in a game](http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/)



## Solutions

### Edit Distance
- **Problem Statement**:
  - We are given two strings and we have to find the minimum number of step in which one string can be converted into the other string.
  - Allowed operations are;
    - Insert : If Less
    - Remove : If more
    - Replace: If different simple
  - Once you have the solution of recursive one you can use it to solve the DP one as well

- **DP matrix explanation:**
  - Rows and columns represent one string each :)
  - dimensions : [str.length + 1][str.length + 1]

## Subset Sum
- **Problem Statement**:
  - Given a set of **+ve integers** find out if there exists a set whose sum is equal to the target sum.
  - So, input would be int[] -> set of +ve integers and
  - targetSum
- **Solution**:
  - It is simple once consider it and other time don't consider it.

- **DP matrix explanation*:
  - **Rows** : Target Sum
    - First row would be zero and means target sum of zero
      - means a[0][j] would be true no matter what
  - **Columns** : indices of the set i.e. a[column] => value of the element in the set at the index equal to column.
  - **dimensions** : ( targetSum + 1 ) x (setSize)
    - +1 to count for the zero target sum
