import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

	// Implement a sufficient number of tests to have
	// reasonable confidence in the correctness of your
	// PostfixEvaluator implementation.

	@Test
	public void test() {
		PostfixEvaluator postfixEvaluator = new PostfixEvaluator("2 3 / 4 /");
		try {
			postfixEvaluator.eval();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
