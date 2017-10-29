package utility;

import java.util.Random;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
public class Functions {
    public static int[] getSampleArray(final int size) {
        final Random randomGenerator = new Random();
        final int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = randomGenerator.nextInt(30);
        }
        return a;
    }

    public static void swap(final int[] a, final int indexOne, final int indexTwo) {
        final int temp = a[indexOne];
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    }
}
