package ds.stack;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
@RunWith(MockitoJUnitRunner.class)
public class NextGreaterElementTest {
    @Test
    public void shouldGetNge() {
        final int[] a =  {11, 13, 21, 3};
        System.out.println("### given Array ###");
        System.out.println(ArrayUtils.toString(a));
        System.out.println("### NGE Array ###");
        System.out.println(ArrayUtils.toString(NextGreaterElement.getNextGreaterElements(a)));
    }
}
