/* Playground - Java - Project Euler
 *  
 * Problem 005
 * http://projecteuler.net/problem=5
 * 
 * "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
 */
public class Problem005 extends AProblem {
	// A very brute-forcey way to do this but you could solve this with a pen and paper yourself :)
	public static int MAX_DIVISOR = 20; // our maximum divisor (the number we are dividing with)

	public static void main(String[] args) {
		int solution = 0, n = 0;

		while (solution == 0) { // if we have no solution:
			n++; // add 1 to our numbers variable (n)
			boolean solved = true; // initializing the solved boolean (it'll tell us when a thing is solved!)
			for (int i = 1; i <= MAX_DIVISOR; i++) { // for all numbers between 1 and MAX_DIVISOR (both included) do:
				if (n % i != 0) { // if our number (n) is not divisible by any divisor (i):
					solved = false; // we haven't solved this
					break; // go and try a new value
				}
			}
			if (solved) { // if the solved boolean hasn't changed [our value (n) was divisible by all divisors (i)]:
				solution = n; // n is our solution!
				break; // break this if
			}
		}
		System.out.println("The smallest number evenly divisible by all the numbers from 1 to " + MAX_DIVISOR + " is: " + solution); // print the solution into the console
	}
}
