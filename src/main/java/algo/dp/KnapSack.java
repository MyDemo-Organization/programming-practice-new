package algo.dp;


public class KnapSack {

    // here target sum is the max wt
    public static int getMaxValueInKnapSack(final int[] wt, final int[] value, final int targetSum) {
        final int n = value.length;
        // here row is sam as current max target weight
        // colum is the index in the wt and value arrays
        // NOTE: in array we are storing value and not wt
        // wt array is just for checking conditions
        final int[][] dp = new int[targetSum + 1][n + 1];

        // fill the dynamic array
        for (int i = 0; i <= targetSum; i++) {
            for (int j = 0; j <= n; j++) {
                // if either the target sum is zero of no element is present then
                // mac value would be zero
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j -1];

                    if (i >= wt[j -1]) {
                        dp[i][j] = Math.max(
                                dp[i][j -1], // excluding
                                value[j -1] + dp[i - wt[j -1]][j -1] // including
                        );
                    }
                }
            }
        }
        return dp[targetSum][n];
    }

    public static void getMaxValueInKnapSackUtilRec() {

    }
}
