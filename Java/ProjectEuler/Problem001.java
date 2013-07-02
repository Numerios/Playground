/* Playground - Java - Project Euler
 *  
 * Problem 001
 * http://projecteuler.net/problem=1
 * 
 * "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *  Find the sum of all the multiples of 3 or 5 below 1000."
 */
public class Problem001 extends AProblem{
	public static int RANGE = 1000;
	public static int[] MULTIPLIERS = { 3, 5 };

	public static void main(String[] args) {
		int solution = 0;
		for (int i = 1; i < RANGE; i++) {
			for (int j = 0; j < MULTIPLIERS.length; j++) {
				if (i % MULTIPLIERS[j] == 0) {
					solution += i;
					break;
				}
			}
		}
		System.out.println("This is the solution: " + solution);
	}
}
