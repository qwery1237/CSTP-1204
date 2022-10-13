import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.

	@Test
	public void test() {
		PostfixEvaluator postfixEvaluator = new PostfixEvaluator("4 2 4 / *");
		try {
			System.out.println(postfixEvaluator.eval());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
