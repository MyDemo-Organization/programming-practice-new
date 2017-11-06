package ds.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
@RunWith(MockitoJUnitRunner.class)
public class ReverseStringTest {

    @Test
    public void shouldReverseStringUsingStack() {
        assertEquals("dcba", ReverseString.reverseString("abcd"));
        assertEquals("", ReverseString.reverseString(""));
        assertEquals("x", ReverseString.reverseString("x"));
        assertEquals("pqr", ReverseString.reverseString("rqp"));
    }

}
