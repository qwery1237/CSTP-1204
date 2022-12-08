package fibTransform;

import java.util.*;

public class fibTransform {

	public static int getFibonacci(int n, int nextFib) {

		Queue<Integer> sum = new LinkedList<>();
		int fibonacci = 0;

		while (n > fibonacci) {
			if (fibonacci == 0){
				sum.add(fibonacci);
				sum.add(++fibonacci);

			}else {
				fibonacci = sum.remove()+sum.peek();
				sum.add(fibonacci);
			}
		}
		while (nextFib-- > 0) {
			if (fibonacci == 0){
				sum.add(fibonacci);
				sum.add(++fibonacci);

			}else {
				fibonacci = sum.remove()+sum.peek();
				sum.add(fibonacci);
			}
		}
		return fibonacci;
	}

	/**
	 * Transform a number into a Fibonacci number using at most m steps: Of
	 * these steps, one can be a doubling step, and the other steps increase
	 * the number at hand by adding 1.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible_onlyOneDoubling(int n, int m) {
		// TODO: Implement this method
		if (m == 0) {
			int i = 0;
			int fib = getFibonacci(n,i++);
			while ( n <= fib) {
				if (n == fib) return true;
				fib = getFibonacci(n,i++);

			}
			return false;
		}

		for (int i = 0; i < m; i++) {
			int num = n;

			for(int j =0; j < m; j++){

				int numGetFib = 0;
				int fibonacci = getFibonacci(n,numGetFib++);

				if(i == j) {
					num*=2;

				}else{
					num++;

				}
				if (fibonacci < num) {
					while (fibonacci < num) {
						fibonacci = getFibonacci(n,numGetFib++);
					}

				}
				if (fibonacci == num) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Transform a number into a Fibonacci number using at most m steps: One can
	 * use any sequence of doubling (*2) or addition (+1) steps as long as the
	 * total number of steps used is no more than m.
	 * 
	 * We are only interested in Fibonacci numbers that can represented as
	 * Integer or int.
	 * 
	 * @param n
	 *            the number to transform to a Fibonacci number, n >= 0
	 * @param m
	 *            the number of transformation steps permitted, m >= 0
	 * @return true if the transformation is possible and false otherwise
	 */
	public static boolean isPossible(int n, int m) {
		// TODO: Implement this method
		List<Integer> numLi = new ArrayList<>();
		return false; // change this
	}

}
