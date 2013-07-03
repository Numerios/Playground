/* Playground - Java - Project Euler
 *  
 * Problem 009
 * http://projecteuler.net/problem=9
 * 
 * "A Pythagorean triplet is a set of three natural numbers, a  b  c, for which, a^2 + b^2 = c^2.
 *  There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc."
 */
public class Problem009 {
	// A bit brute-forcey
	public static int GOAL = 1000; // the number we're trying to get to

	public static void main(String[] args) {
		int a = 1, b = 1, c = 1; // initialize a, b and c
		int solution = 0; // the solution
		for (a = 1; a < GOAL; a++) { // for all numbers (a) between 1 and GOAL do:
			for (b = 1; b < (GOAL - a); b++) { // for all numbers (b) between 1 and (GOAL - a) do:
				c = (GOAL - a - b); // a + b + c = GOAL => c = GOAL - a - b
				if ((a * a + b * b) == c * c) { // if the number is a Pythagorean triplet: 
					solution = a * b * c; // it is a solution!
				}
			}
		}
		System.out.println("The desired triplet with sum of a, b, c equaling to " + GOAL + " is: " + solution + "!"); // Print the solution into the console
	}
}
