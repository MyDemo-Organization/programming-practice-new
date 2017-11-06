package ds.stack;

import java.util.Stack;

/**
 * Problem Statement: "In place stack reversal using the recursion!!"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class ReverseStack {

    public static void reverseStack(final Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        final int removedValue = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, removedValue);
    }

    private static void insertAtBottom(final Stack<Integer> stack, final int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        final int removedValue = stack.pop();
        insertAtBottom(stack, value);
        stack.push(removedValue);
    }
}
