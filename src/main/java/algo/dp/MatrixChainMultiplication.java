package algo.dp;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/2/17
 */
public class MatrixChainMultiplication {

    // solution available at http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
    public static int getMinCostMatrixChainMultiplication(final int[] p) {

        // length of the array
        final int n = p.length;

        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }

    // important ranges are;
    // STEP 1 : i 1 to n
    // STEP 2:

    /**
     * important ranges are
     * STEP 1 : i 1 to n
     * STEP 2: Inner Loops involving L,i,j, and k
     * L -> 2 to n -1
     * i -> 1 to n - L
     * k -> i to j - 1 where j is a constant for the given inside loop j = L +i -1
     */
    public static int getMinCostMatrixChainMultiplication2(final int[] p) {
        final int n = p.length;
        final int[][] dp = new int[n][n];
        int i, j, k, lengthOfChain, cost2Multiply;

        // initialize cost to 0 when we are multiplying with itself
        // NOTE: we are starting from 1 to n :)
        for (i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        // keep on increasing the length
        for (lengthOfChain = 2; lengthOfChain < n; lengthOfChain++) {

            // select the matrix range to multiply
            // i represents the columns and indicates the index of the matrix being multiplied
            for (i = 1; i < n - lengthOfChain + 1; i++) {

                // initalize j to be in the next half of the diagonal
                j = i + lengthOfChain -1;

                if (j == n)
                    continue;

                // initialize the cost to be mazximum
                dp[i][j] = Integer.MAX_VALUE;

                for (k = i; k < j; k++) {
                    cost2Multiply = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];

                    // update the cost if the new cost is smaller than the new one
                    if (cost2Multiply < dp[i][j]) {
                        dp[i][j] = cost2Multiply;
                    }
                }
            }
        }

        return dp[1][n-1];
    }

    /**
     * important ranges are
     * STEP 1 : i 1 to n
     * STEP 2: Inner Loops involving L,i,j, and k
     * L -> 2 to n -1
     * i -> 1 to n - L
     * k -> i to j - 1 where j is a constant for the given inside loop j = L +i -1
     */
    public static int getMinCostMatrixChainMultiplication3(final int[] p) {
        // STEP 1 : Initialize
        final int n = p.length;

        final int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // STEP 2: keep repeating the logic for the remaining
        for (int lengthOfChain = 2; lengthOfChain <= n - 1; lengthOfChain++) {
            for (int i = 1; i <= n - lengthOfChain; i++) {
                final int j = i + lengthOfChain - 1;

                if (j == n)
                    continue;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j -1; k++) {
                    final int currentCost2Multiply = dp[i][k] + dp[k+1][j] + p[i - 1]*p[k]*p[j];
                    dp[i][j] = (currentCost2Multiply < dp[i][j]?currentCost2Multiply:dp[i][j]);
                }
            }
        }

        return dp[1][n -1];
    }
}
