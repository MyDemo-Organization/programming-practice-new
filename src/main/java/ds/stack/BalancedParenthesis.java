package ds.stack;

import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class BalancedParenthesis {

    public static boolean isBalanced(final String expression) {

        final char[] exp = expression.toCharArray();
        final Stack<Character> stack = new Stack<>();

        for (final char ch : exp) {
            if (ch == ' ') {
                continue;
            }else if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                    // make sure the order of the parameters in the function isMatched is proper
                } else if(!isMatched(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(final char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isMatched(final char openingBracket, final char closingBracket) {
        switch (openingBracket){
            case '(':
                return closingBracket == ')';
            case '[':
                return closingBracket == ']';
            case '{':
                return closingBracket == '}';
            default:
                    return false;
        }
    }
}
