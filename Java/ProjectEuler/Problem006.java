/* Playground - Java - Project Euler
 *  
 * Problem 006
 * http://projecteuler.net/problem=6
 * 
 * "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
 */
public class Problem006 extends AProblem{
	public static int RANGE = 100; // our static variable of the range we'll use when deciding from which range should we grab numbers

	public static void main(String[] args) {
		int a = 0; // the sum of the squares of all integers within RANGE
		int	b = 0; // the square of the sum of all integers within RANGE
		
		for (int i = 1; i <= RANGE; i++) {  // for all numbers that are between 1 and RANGE (including both 1 and RANGE themselves)
			a += (i*i); // adding the number (i) squared to a
			b += i; // adding the number (i) to b
		}
		b = b*b; // squaring b
		int solution = Math.abs(b - a); // calculating the solution (difference between a and b)
		System.out.println("The difference equals to: " + solution + "!"); // printing the solution into the console
	}
}
