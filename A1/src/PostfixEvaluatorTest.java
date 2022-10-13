import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.

	@Test
	public void test() throws MalformedExpressionException {
		PostfixEvaluator postfixEvaluator = new PostfixEvaluator("8 2 4 6 6 * / /");
		System.out.println(postfixEvaluator.eval());
	}

}
