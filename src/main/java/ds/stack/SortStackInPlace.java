package ds.stack;

import java.util.Stack;

/**
 * Problem Statement: "Sort stack in place"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class SortStackInPlace {

    public static void sortStack(final Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        final int currentValue = stack.pop();
        sortStack(stack);
        insertAtRightPlace(stack, currentValue);
    }

    private static void insertAtRightPlace(final Stack<Integer> stack, final int value) {
        // base case
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        // correct place has reached
        if (stack.peek() <= value) {
            stack.push(value);
            return;
        }

        final int currentValue = stack.pop();
        insertAtRightPlace(stack, value);
        stack.push(currentValue);
    }
}
