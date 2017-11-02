package algo.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class KnapSackTest {

    @Test
    public void shouldGetMaxKnapSackValueDP() {
        final int values[] = new int[]{60, 100, 120};
        final int wt[] = new int[]{10, 20, 30};
        final int  targetWeight = 50;
        assertEquals(220, KnapSack.getMaxValueInKnapSack(wt, values, targetWeight));
    }
}
