package algo.dp;


public class EditDistance {

    // TC : O(N^3)
    public static int getEditDistanceRec(final String str1, final String str2) {
        return getEditDistanceUtilRec(
                str1.toCharArray(),
                str2.toCharArray(),
                str1.length(),
                str2.length()
        );
    }

    // snce for each character we have three possibilites
    // Time Complexity would be O(N^3)
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

