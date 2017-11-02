package algo.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EditDistanceTest {

    @Test
    public void shouldGetEditDistanceRecursive() {
        assertEquals(3, EditDistance.getEditDistanceRec("sunday", "saturday"));
        assertEquals(8, EditDistance.getEditDistanceRec("", "saturday"));
        assertEquals(6, EditDistance.getEditDistanceRec("sunday", ""));
    }

    @Test
    public void shouldGetEditDistanceDP() {
        assertEquals(3, EditDistance.getEditDistanceDP("sunday", "saturday"));
        assertEquals(8, EditDistance.getEditDistanceDP("", "saturday"));
        assertEquals(6, EditDistance.getEditDistanceDP("sunday", ""));
    }
}
