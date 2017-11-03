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
- [Min Cost Path](http://www.geeksforgeeks.org/dy namic-programming-set-6-min-cost-path/)
- [Coin change](http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/)
- [Matrix Chain Multiplication](http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/) :small_red_triangle: :white_check_mark:
- [Binomial Coefficient](http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/)
  - OR nCr
- [KnapSack Problem](http://www.geeksforgeeks.org/knapsack-problem/) :white_check_mark:
- [Subset Sum Problem](http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/) :white_check_mark:
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


## 0-1 KnapScak
- Same As Subset Just one condition change :)
- o.e.
- Used the same structure as the subset sum dp
  - Use my solutions only and don;t go for the g4g solution

## Matrix Chain Multiplication:
- The problem is not to multiply bu to check the order in which they should be multiplied so that the number of operations performed are minimal.
- For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
    ```shell
    (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
    A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
    ```
- So final results are going to be the same and we are just trying to minimize the cost.
- Just **memorize** the solution :smile:
- Note:
  - For dimension of the matrix we are given an array p[] where Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
  - SO for the dimension of 3 matrices we will have an array of size n = 4.
  - or printing the parenthesization look for this g4g link [g4g](http://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/)
  - This is also one reference [youtube link](https://www.youtube.com/watch?v=vgLJZMUfnsU)

  - Number of rows and columns indicate the matrix index and 1,1  value in the matrix indicate cost of multiplying matrices from 1 to 1 which would 0 as we don't cost anything for multiplying with yourself.
