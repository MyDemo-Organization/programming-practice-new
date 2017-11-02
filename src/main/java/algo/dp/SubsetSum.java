package algo.dp;

public class SubsetSum {

    public static boolean isSubsetPresentDP(final int[] set, final int sum) {

        // base case
        if (sum < 0) {
            return false;
        }

        final int n = set.length;

        boolean dp[][] = new boolean[sum+1][n+1];

        // 0 sum is present in all the sets
        for (int i = 0; i <= n; i++)
            dp[0][i] = true;

        // epmty set doesn't have any sum other than the target sum of 0
        for (int i = 1; i <= sum; i++)
            dp[i][0] = false;


        // fill in the dp table
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                dp[i][j] = dp[i][j-1];
                if (i >= set[j-1])
                    dp[i][j] = dp[i][j] ||
                            dp[i - set[j-1]][j-1];
            }
        }

        return dp[sum][n];

    }

    public static boolean isSubsetPresentDP2(final int[] set, final int targetSum) {
        if (targetSum < 0) {
            return false;
        }
        final int n = set.length;
        final boolean[][] dp = new boolean[targetSum + 1][n + 1];

        // initialize
        // sum of zero is present in all the subsets
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }

        // empy set doesn;t have any target sum except 0
        for (int i = 1; i <= targetSum; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= targetSum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                // this condition is necessary to make sure we don;t get outof bound exceptions
                if (i >= set[j -1]) {
                    dp[i][j] = dp[i][j] || dp[i - set[j -1]][j -1]; // including and excluding
                }
            }
        }

        return dp[targetSum][n];
    }

    // tc(2^N)
    public static boolean isSubsetPresentRec(final int[] set, final int targetSum) {
        return isSubsetPresentUtilRec(set, targetSum, set.length - 1);
    }

    private static boolean isSubsetPresentUtilRec(final int[] set,
                                               final int targetSum,
                                               int currentIndex) {
        // base case 1
        if (targetSum == 0) {
            return true;
        }

        //base case 2
        if (currentIndex < 0 ) {
            return false;
        }

        // we can add one more condition here to optimize it by excluding the elements
        // which are greater than the target sum

                // including current index
        return isSubsetPresentUtilRec(set, targetSum - set[currentIndex], currentIndex -1) ||
                // excluding current index
                    isSubsetPresentUtilRec(set, targetSum, currentIndex -1);

    }
}
