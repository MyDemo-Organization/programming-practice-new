package ds.heap;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/28/17
 */
@RunWith(MockitoJUnitRunner.class)
public class SortTheAlmostSortedArrayTest {

    @Test
    public void shouldSortKSortedArray() {
        final int[] a = {2, 6, 3, 12, 56, 8};
        final int k = 3;

        System.out.println("### Before Sorting ###");
        System.out.println(ArrayUtils.toString(a));
        SortTheAlmostSortedArray.sortKSortedArray(a, k);
        System.out.println("### After Sorting ###");
        System.out.println(ArrayUtils.toString(a));

    }
}
