package ds.stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
@RunWith(MockitoJUnitRunner.class)
public class SortStackInPlaceTest {

    @Test
    public void shouldReverseStackInPlace() {
        final Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(4);

        System.out.println("### Normal Stack ###");
        System.out.println(stack);
        SortStackInPlace.sortStack(stack);
        System.out.println("### Sorted Stack ###");
        System.out.println(stack);
    }

}
