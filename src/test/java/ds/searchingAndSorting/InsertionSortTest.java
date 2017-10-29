package ds.searchingAndSorting;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utility.Functions;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
@RunWith(MockitoJUnitRunner.class)
public class InsertionSortTest {

    @Test
    public void shouldDoInsertionSort() {
        for (int i = 0; i < 5; i++) {
            int[] a = Functions.getSampleArray(10);
            System.out.println("### Before Sorting ###");
            System.out.println(ArrayUtils.toString(a));
            InsertionSort.insertionSort(a);
            System.out.println("### After Sorting ###");
            System.out.println(ArrayUtils.toString(a));
            System.out.println();
        }
    }

}
