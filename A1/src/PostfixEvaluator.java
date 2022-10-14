import java.util.Stack;

public class PostfixEvaluator {

	private String arithmeticExpr;
	private String errMsg = "Not valid expression!";

	public PostfixEvaluator(String expr) {
		arithmeticExpr = expr;
	}

	double eval() throws MalformedExpressionException {

		Stack<Double> stack = new Stack<>();
		Double result = 0.0;
		Double num1 = 0.0;
		Double num2 = 0.0;
		Scanner scanner = new Scanner(arithmeticExpr);
		Token currToken = scanner.getToken();

		while (!scanner.isEmpty()) {
			if (currToken.isDouble()) {
				stack.push(currToken.getValue());
			} else {
				try {
					num2 = stack.pop();
					num1 = stack.pop();
				} catch (Exception e) {
					throw new MalformedExpressionException(errMsg + " not enough number");
				}
				stack.push(calculate(num1, num2, currToken.getName()));
			}
			scanner.eatToken();
			currToken = scanner.getToken();
		}
		result = stack.pop();
		if (!stack.isEmpty())
			throw new MalformedExpressionException(errMsg + " not enough operator");

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
		throw new MalformedExpressionException(errMsg + " Invalid operator");
	}
}