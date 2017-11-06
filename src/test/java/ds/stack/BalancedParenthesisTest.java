package ds.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
@RunWith(MockitoJUnitRunner.class)
public class BalancedParenthesisTest {

    @Test
    public void shouldCheckIfBalanced() {
        final String expression = "{()}[]";
        assertTrue(BalancedParenthesis.isBalanced(expression));
        assertTrue(BalancedParenthesis.isBalanced(""));
        assertTrue(BalancedParenthesis.isBalanced("()"));
        assertFalse(BalancedParenthesis.isBalanced("(()"));
        assertFalse(BalancedParenthesis.isBalanced("{}(){"));

    }
}
