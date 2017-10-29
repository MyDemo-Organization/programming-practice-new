package ds.searchingAndSorting;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utility.Functions;

import java.util.Arrays;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/29/17
 */
@RunWith(MockitoJUnitRunner.class)
public class MergeSortTest {

    @Test
    public void shouldDoMergeSort() {
        for (int i = 0; i < 5; i++) {
            int[] a = Functions.getSampleArray(6);
            System.out.println("### Before Sorting ###");
            System.out.println(ArrayUtils.toString(a));
            System.out.println("### After Sorting ###");
            MergeSort.mergeSort(a);
            System.out.println(ArrayUtils.toString(a));
            System.out.println();
        }
    }

}
