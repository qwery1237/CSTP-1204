import org.junit.Test;
import fibTransform.fibTransform;

import static org.junit.Assert.assertEquals;

public class FibTransformTest {

	@Test
	public void test_6_2() {
		assertEquals(true, fibTransform.isPossible_onlyOneDoubling(6, 2));
	}

	@Test
	public void test_10_3() {
		assertEquals(true, fibTransform.isPossible_onlyOneDoubling(10, 3));
	}

	@Test
	public void test_22_3_1() {
		assertEquals(false, fibTransform.isPossible_onlyOneDoubling(22, 3));
	}

	@Test
	public void test_22_3_2() {
		assertEquals(true, fibTransform.isPossible(22, 3));
	}

	@Test
	public void test_0_0() {
		assertEquals(true, fibTransform.isPossible_onlyOneDoubling(0, 0));
	}

	@Test
	public void test_20_0() {
		assertEquals(false, fibTransform.isPossible_onlyOneDoubling(20, 0));
	}

	@Test
	public void test_24_6() {
		assertEquals(true, fibTransform.isPossible_onlyOneDoubling(24, 6));
	}

	@Test
	public void test_1000_18_1() {
		assertEquals(false, fibTransform.isPossible_onlyOneDoubling(1000, 18));
	}

	@Test
	public void test_1000_18_2() {
		assertEquals(true, fibTransform.isPossible(1000, 18));
	}
}
