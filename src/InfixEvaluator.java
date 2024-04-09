import java.util.Stack;

/**
 * @author Davine Mungai
 * This class provides a utility for evaluating infix expressions.
 */
public class InfixEvaluator {

    /**
     * Class to report a syntax error.
     */
    public class SyntaxErrorException extends RuntimeException {

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
    private boolean isOperator(Character op) {
        return false;
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
        Stack<Character> operatorStack = new Stack<>();

        return 0;
    }

}
