import java.util.Scanner;
import java.util.Stack;

/**
 * @author Davine Mungai
 *         This class provides a utility for evaluating infix expressions.
 */
public class InfixEvaluator {

    /**
     * Class to report a syntax error.
     */
    public static class SyntaxErrorException extends RuntimeException {

        /**
         * Construct a SyntaxErrorException with the specified
         * message.
         * 
         * @param message the error message.
         */
        public SyntaxErrorException(String message) {
            super(message);
        }
    }

    /**
     * Checks if a given character is an operator.
     *
     * @param op the character to be checked
     * @return true if the character is an operator, false otherwise
     */
    private static boolean isOperator(String token) {

        return token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/") || token.equals("^") || token.equals("%") || token.equals("(") || token.equals(")");
    }

    /**
     * checks precidence of the current operator
     * 
     * @param operator String representation of the operator
     * @return precedence of operator
     */
    private static int precedence(String operator) {

        switch (operator) {
            case "^":
                return 3;
            case "/":
            case "*":
            case "%":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }

    }

    /**
     * Calculates the result of applying the specified operator to the given
     * operands.
     *
     * @param lHS      the left-hand side operand
     * @param rHS      the right-hand side operand
     * @param operator the operator to apply
     * @return the result of the operation
     */
    private static int calculateDigits(int lHS, int rHS, String operator) {
        int result = 0;

        // calculate ^
        if (operator.equals("^")) {
            result = 1;

            for (int i = 0; i < rHS; i++) {
                result *= lHS;
            }
            
        }

        // calculate /
        if (operator.equals("/")) {
            result = lHS / rHS;
        }

        // calculate *
        if (operator.equals("*")) {
            result = lHS * rHS;
        }

        // calculate +
        if (operator.equals("+")) {
            result = lHS + rHS;
        }

        // calculate -
        if (operator.equals("-")) {
            result = lHS - rHS;
        }

        // calculate %
        if (operator.equals("%")){
            result = lHS % rHS;
        }

        return result;
    }

    /**
     * Evaluates an infix expression and returns the result.
     *
     * @param expression the infix expression to be evaluated
     * @return the result of the evaluation
     */
    public static int evaluate(String expression) {

        // stacks to contain operands and operators
        Stack<Integer> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        // scanner to read expression space by space
        Scanner scanner = new Scanner(expression);
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            String token = scanner.next();

            if (!isOperator(token)) {
                operandStack.push(Integer.valueOf(token));
            } else {
                if (token.equals("(")) {
                    operatorStack.push(token); // Push '(' onto the operator stack
                } 
                else if (token.equals(")")) {
                    // Evaluate the expression inside parentheses
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        int rhs = operandStack.pop();
                        int lhs = operandStack.pop();
                        String op = operatorStack.pop();
                        operandStack.push(calculateDigits(lhs, rhs, op));
                    }
                    // Discard the '('
                    if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                        operatorStack.pop();
                    } 
                    else {
                        // in case of unbalanced parentheses
                        throw new SyntaxErrorException("Unbalanced parentheses");
                    }
                } 
                else {
                    // While there are operators on the stack with higher precedence
                    while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                        int rhs = operandStack.pop();
                        int lhs = operandStack.pop();
                        String op = operatorStack.pop();
                        operandStack.push(calculateDigits(lhs, rhs, op));
                    }
                    // Push the current operator to the operator stack
                    operatorStack.push(token);
                }
            }
        }

        // Evaluate remaining operations
        while (!operatorStack.isEmpty()) {
            int rhs = operandStack.pop();
            int lhs = operandStack.pop();
            String op = operatorStack.pop();
            operandStack.push(calculateDigits(lhs, rhs, op));
        }

        scanner.close();
        return operandStack.peek();
    }

}
