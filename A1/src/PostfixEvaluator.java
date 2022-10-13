import java.util.Stack;

/**
 * 
 * 
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See
 * <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
 * for details on the notation.
 *
 */
public class PostfixEvaluator {

	private String arithmeticExpr;
	private String errMsg = "Not valid expression!";

	/**
	 * This is the only constructor for this class.
	 * It takes a string that represents an arithmetic expression
	 * as input argument.
	 * 
	 * @param expr is a string that represents an arithmetic expression
	 *             <strong>in Postfix notation</strong>.
	 */
	public PostfixEvaluator(String expr) {
		arithmeticExpr = expr;
	}

	/**
	 * This method evaluates the arithmetic expression that
	 * was passed as a string to the constructor for this class.
	 * 
	 * @return the value of the arithmetic expression
	 * @throws MalformedExpressionException if the provided expression is not
	 *                                      a valid expression in Postfix notation
	 */
	double eval() throws MalformedExpressionException {
		// TODO: Implement this method.
		// The code provided here is for illustration only, and
		// can be deleted when you write your implementation.

		// Using a stack makes it very simple to evaluate the
		// arithmetic expression.
		// See http://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

		// Use the Scanner to get the elements (tokens) in the
		// arithmetic expression.

		Stack<Double> stack = new Stack<>();
		Double result = 0.0;
		Scanner scanner = new Scanner(arithmeticExpr);
		Token currToken = scanner.getToken();
		scanner.
		while (!scanner.isEmpty()) {
			if (currToken.isDouble()) {
				stack.push(currToken.getValue());
			} else {
				Double num2 = stack.pop();
				Double num1 = stack.pop();
				stack.push(calculate(num1, num2, currToken.getName()));
			}
			scanner.eatToken();
			currToken = scanner.getToken();
		}
		result = stack.pop();
		// now process the token, etc.
		// You should read the implementation of the Token class
		// to determine what methods you can and should use.

		// It is sufficient to support the four basic operations:
		// addition, subtraction, multiplication & division.

		return result;
	}

	Double calculate(Double num1, Double num2, String operator) throws MalformedExpressionException {
		switch (operator) {
			case "+":
				return num1 + num2;
			case "-":
				return num1 - num2;
			case "*":
				return num1 * num2;
			case "/":
				return num1 / num2;
		}
		throw new MalformedExpressionException(errMsg);
	}
}