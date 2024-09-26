# Infix Evaluator Project

## Project Overview

This project implements an **Infix Expression Evaluator** in Java. The evaluator processes mathematical expressions written in infix notation (e.g., `(3 + 5) * 2`) and returns the result. It supports basic arithmetic operations, including addition, subtraction, multiplication, division, modulus, and exponentiation, while respecting operator precedence and parentheses.

## Features

- **Infix Evaluation**: Supports evaluation of infix expressions with parentheses and operators.
- **Operator Precedence**: Handles precedence of operators (`^`, `*`, `/`, `%`, `+`, `-`).
- **Error Handling**: Includes a custom exception class to handle syntax errors, such as unbalanced parentheses.

## Key Functions

- `evaluate(String expression)`: Evaluates the given infix expression and returns the result.
- `calculateDigits(int lHS, int rHS, String operator)`: Performs calculations based on the operator between two operands.
- `precedence(String operator)`: Returns the precedence of a given operator.
- `isOperator(String token)`: Checks if a string is a valid operator.

## Tech Stack

- **Language**: Java
- **Concepts Applied**: Stack Data Structure, Operator Precedence, Error Handling, Expression Parsing

## Example Code with Main Method

Here’s how you can use the `InfixEvaluator` class with a `main` method to evaluate an infix expression:

```java
public class Main {

    public static void main(String[] args) {
        // Example infix expression
        String expression = "( 3 + 5 ) * 2";
    
        // Evaluate the expression using InfixEvaluator
        int result = InfixEvaluator.evaluate(expression);
        System.out.println("The result of the expression '" + expression + "' is: " + result);
    
    }
}
```

### Example Output:
```
The result of the expression '( 3 + 5 ) * 2' is: 16
```

## How to Run

1. **Clone the repository**:
   ```bash
   git clone <repo_url>
   cd InfixEvaluator
   ```

2. **Compile the code**:
   ```bash
   javac Main.java InfixEvaluator.java
   ```

3. **Run the program**:
   ```bash
   java Main
   ```
