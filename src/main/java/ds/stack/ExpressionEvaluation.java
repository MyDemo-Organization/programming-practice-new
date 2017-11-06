package ds.stack;

import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/5/17
 */
public class ExpressionEvaluation {

    public static String infixToPostFix(final String expression) {
        final char[] exp = expression.toCharArray();
        final Stack<Character> stack = new Stack<>();
        final StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == ' ') {
                continue;
            } else if (Character.isDigit(exp[i])) {
                final StringBuilder currentDigit = new StringBuilder();
                while (i < exp.length && Character.isDigit(exp[i])) {
                    currentDigit.append(exp[i]);
                    i++;
                }

                // move back again
                i--;
                outputString.append(" " + currentDigit);
            } else if (isOpeningBracket(exp[i])) {
                stack.push(exp[i]);
            } else if (isClosingBracket(exp[i])) {
                while (!stack.isEmpty() && stack.peek() != getMatchedBracket(exp[i])) {
                    outputString.append(" " + stack.pop());
                }

                // make sure we have found the matching bracket
                if (stack.isEmpty()) {
                    System.out.println("Invalid expression!");
                    return null;
                }

                // remove the opening bracket
                stack.pop();
            } else if (isOperator(exp[i])) {

                // the second condition is more important as we have to make sure that any operator having more presendece
                // should be appended to the output string
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(exp[i])) {
                    outputString.append(" " + stack.pop());
                }

                stack.push(exp[i]);
            } else {
                System.out.println("ERROR: Invalid expression!");
                return null;
            }
        }

        // empty the stack
        while (!stack.isEmpty() && !isOpeningBracket(stack.peek())) {
            outputString.append(" " + stack.pop());
        }

        if (!stack.isEmpty()) {
            System.out.println("ERROR: Invalid expression!");
            return null;
        }
        return outputString.toString();
    }

    private static char getMatchedBracket(final char openingBracket) {
        switch (openingBracket){
            case ')':
                return '(';
            case ']':
                return  '[';
            case '}':
                return '{';
            default:
                return '\0';
        }
    }


    private static boolean isOpeningBracket(final char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isClosingBracket(final char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isOperator(final char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^';
    }

    private static int precedence(final char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return 0;
        }
    }
}
