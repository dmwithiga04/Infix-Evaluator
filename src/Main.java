public class Main {

    public static void main(String[] args) {
        // Example infix expression
        String expression = "( 3 + 5 ) * 2";
    
        // Evaluate the expression using InfixEvaluator
        int result = InfixEvaluator.evaluate(expression);
        System.out.println("The result of the expression '" + expression + "' is: " + result);
    
    }
}
