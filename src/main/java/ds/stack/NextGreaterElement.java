package ds.stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class NextGreaterElement {

    // Time Complexity : O(N)
    public static int[] getNextGreaterElements(final int[] a) {
        if (a.length < 1) {
            return null;
        }

        final int[] nge = new int[a.length];

        nge[a.length -1] = -1;

        for (int i = a.length - 2; i >= 0; i--) {

            if (a[i+1] > a[i]) {
                nge[i] = a[i+1];
            } else {
                nge[i] = nge[i+1];
            }
        }

        return nge;
    }
}
