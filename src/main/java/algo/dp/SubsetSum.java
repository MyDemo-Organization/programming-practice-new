package algo.dp;

public class SubsetSum {

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
