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
		for (int i = 1; i < RANGE; i++) { //for each number that is between 1 and RANGE do:
			for (int j = 0; j < MULTIPLIERS.length; j++) { //for each number that is in MULTIPLIERS do:
				if (i % MULTIPLIERS[j] == 0) { //if a current number (i) is divisible by current multiplier (j)
					solution += i; //add current number (i) to solution sum
					break; //prevents adding two same numbers to the solution sum (happens when there is a number that is divisible by two or more multipliers)
				}
			}
		}
		System.out.println("This is the solution: " + solution);
	}
}
