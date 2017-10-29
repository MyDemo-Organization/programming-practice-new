package ds.searchingAndSorting;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utility.Functions;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/28/17
 */
@RunWith(MockitoJUnitRunner.class)
public class BubbleSortTest {

    @Test
    public void shouldBubbleSort() {
        for (int i = 0; i < 5; i++) {
            final int[] array = Functions.getSampleArray(10);
            System.out.println("###  Before Sorting ###");
            System.out.println(ArrayUtils.toString(array));
            System.out.println("###  After Sorting ###");
            System.out.println(ArrayUtils.toString(BubbleSort.bubbleSort(array)));
            System.out.println();
        }
    }

}
