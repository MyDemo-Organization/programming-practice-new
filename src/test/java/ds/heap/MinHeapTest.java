package ds.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
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
public class MinHeapTest {
    private MinHeap minHeap = new MinHeap(8);

    @Before
    public void setup() {
        minHeap.createSampleHeap();
        System.out.println(minHeap);
    }

    @Test
    public void shouldCreateHeap() {
        System.out.println("### Deleting " + minHeap.getHeapArray()[3] + " ###");
        minHeap.deleteKey(3);
        System.out.println(minHeap);

        System.out.println("### getMin() ###");
        System.out.println("Minimum of all :" + minHeap.getMin());
        System.out.println(minHeap);

        System.out.println("### extractMin() ###");
        minHeap.extractMin();
        System.out.println(minHeap);
    }
}
