package algo.dp;


public class EditDistance {

    public static int getEditDistanceDP(final String str1, final String str2) {
        // create a 2D array to store the results
        final int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // lets create the dp array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // case 1
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + minOfThree(
                            dp[i][j -1],       // insertion
                            dp[i - 1][j],       // deletion
                            dp[i -1][j - 1]     // replacement
                    );
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    // TC : O(3^N)
    public static int getEditDistanceRec(final String str1, final String str2) {
        return getEditDistanceUtilRec(
                str1.toCharArray(),
                str2.toCharArray(),
                str1.length(),
                str2.length()
        );
    }

    // snce for each character we have three possibilites
    // Time Complexity would be O(3^N)
    private static int getEditDistanceUtilRec(final char[] str1,
                                           final char[] str2,
                                           final int str1Index,
                                           final int str2Index) {

        // Base case 1: One of the string has ended
        if (str1Index == 0 ) {
            return str2Index;
        }

        if (str2Index == 0) {
            return str1Index;
        }

        // Base case 2: Both of them have the same characters
        if (str1[str1Index - 1] == str2[str2Index -1]) {
            return getEditDistanceUtilRec(str1, str2, str1Index - 1, str2Index - 1);
        }

        return 1 + minOfThree(
                getEditDistanceUtilRec(str1, str2, str1Index, str2Index - 1), // insertion
                getEditDistanceUtilRec(str1, str2, str1Index - 1, str2Index), // deletion
                getEditDistanceUtilRec(str1, str2, str1Index - 1, str2Index - 1) // replacement
        );
    }

    private static int minOfThree(final int a, final int b, final int c) {
        return Math.min(Math.min(a, b), c);
    }
}

