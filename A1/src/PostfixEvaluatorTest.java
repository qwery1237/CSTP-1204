import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PostfixEvaluatorTest {

  // Implement a sufficient number of tests to have
  // reasonable confidence in the correctness of your
  // PostfixEvaluator implementation.

  @Test
  public void test() throws MalformedExpressionException {
    PostfixEvaluator validExp = new PostfixEvaluator("8 2 4 6  * / /");
    PostfixEvaluator validExp2 = new PostfixEvaluator("8 2 4 * +");
    PostfixEvaluator validExp3 = new PostfixEvaluator("8 4 2 - /");
    assertEquals(96.0, validExp.eval());
    assertEquals(16.0, validExp2.eval());
    assertEquals(4.0, validExp3.eval());
  }

  @Test
  public void test2() throws MalformedExpressionException {
    PostfixEvaluator invalidOperator = new PostfixEvaluator("8 2 4 6 * &");
    try {
      invalidOperator.eval();
    } catch (MalformedExpressionException e) {
      assertEquals("Not valid expression! Invalid operator", e.getMessage());
    }

  }

  @Test
  public void test3() throws MalformedExpressionException {
    PostfixEvaluator notEnoughNum = new PostfixEvaluator("82 4 6 * / /");
    try {
      notEnoughNum.eval();
    } catch (MalformedExpressionException e) {
      assertEquals("Not valid expression! not enough number", e.getMessage());
    }

  }

  @Test
  public void test4() throws MalformedExpressionException {
    PostfixEvaluator notEnoughOperator = new PostfixEvaluator("8 2 4 6 * /");
    try {
      notEnoughOperator.eval();
    } catch (MalformedExpressionException e) {
      assertEquals("Not valid expression! not enough operator", e.getMessage());
    }
  }

}