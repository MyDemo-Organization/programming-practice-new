package ds.stack;

import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class ReverseString {
    public static String reverseString(final String string) {
        final char[] str = string.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder(str.length);

        final Stack<Character> stack = new Stack<>();

        for (final char currentChar : str) {
            stack.push(currentChar);
        }


        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }


        return stringBuilder.toString();

    }
}
