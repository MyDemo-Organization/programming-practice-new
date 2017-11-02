package algo.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SubsetSumTest {

    @Test
    public void shouldCheckSubsetRec() {
        final int[] set = {1,2,3};
        assertEquals(false, SubsetSum.isSubsetPresentRec(set, 7));
        assertEquals(true, SubsetSum.isSubsetPresentRec(set, 5));
        assertEquals(true, SubsetSum.isSubsetPresentRec(set, 0));
        assertEquals(true, SubsetSum.isSubsetPresentRec(set, 6));
        assertEquals(true, SubsetSum.isSubsetPresentRec(set, 1));
        assertEquals(false, SubsetSum.isSubsetPresentRec(set, -5));
    }

    @Test
    public void shouldCheckSubsetDP() {
        final int[] set = {1,2,3};
        assertEquals(false, SubsetSum.isSubsetPresentDP(set, 7));
        assertEquals(true, SubsetSum.isSubsetPresentDP(set, 5));
        assertEquals(true, SubsetSum.isSubsetPresentDP(set, 0));
        assertEquals(true, SubsetSum.isSubsetPresentDP(set, 6));
        assertEquals(true, SubsetSum.isSubsetPresentDP(set, 1));
        assertEquals(false, SubsetSum.isSubsetPresentDP(set, -5));
    }

    @Test
    public void shouldCheckSubsetDP2() {
        final int[] set = {1,2,3};
        assertEquals(false, SubsetSum.isSubsetPresentDP2(set, 7));
        assertEquals(true, SubsetSum.isSubsetPresentDP2(set, 5));
        assertEquals(true, SubsetSum.isSubsetPresentDP2(set, 0));
        assertEquals(true, SubsetSum.isSubsetPresentDP2(set, 6));
        assertEquals(true, SubsetSum.isSubsetPresentDP2(set, 1));
        assertEquals(false, SubsetSum.isSubsetPresentDP2(set, -5));
    }
}
