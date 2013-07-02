/* Playground - Java - Project Euler
 *  
 * Problem 002
 * http://projecteuler.net/problem=2
 * 
 * "Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 *  By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms."
 */
public class Problem002 extends AProblem{
	public static int SOLUTION_RANGE = 4000000;
	public static int DIVISOR = 2;

	public static void main(String[] args) {
		int solution = 0;

		/*
		 * Fibonacci's sequence is the sum of two previous numbers.
		 * 1,2,3,5,8,13,21
		 */

		int fib = 2;
		int fibPrev = 1;
		int temp = 0;

		while (solution < SOLUTION_RANGE) {
			if (fib % 2 == 0) {
				solution += fib;
			}
			temp = fib; // storing the fibonacci's number
			fib += fibPrev; // adding the latest fibonacci's number with the previous one creating a new one
			fibPrev = temp; // the previous fibonacci's number to current one was stored in temp so we just assign its value to "fibPrev"
		}
		
		System.out.println("Largest Fibonacci's number within bounds ("
				+ SOLUTION_RANGE + ") " + ": " + fibPrev);
		System.out.println("The final solution is: " + solution);
	}
}
