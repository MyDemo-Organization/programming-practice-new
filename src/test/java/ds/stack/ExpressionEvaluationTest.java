package ds.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: "Infix to postfix test"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
@RunWith(MockitoJUnitRunner.class)
public class ExpressionEvaluationTest {

    @Test
    public void shouldConvertInfixTOPostfix() {
// (a+b*c-d)/(e*f) -> (1+2*3-4)/(5*6)

        final String expression = "(1+2*3-4)/(5*6)";
        System.out.println(ExpressionEvaluation.infixToPostFix(expression));
    }
}
