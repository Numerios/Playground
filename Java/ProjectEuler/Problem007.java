/* Playground - Java - Project Euler
 *  
 * Problem 007
 * http://projecteuler.net/problem=7
 * 
 * "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *  What is the 10 001st prime number?"
 */
public class Problem007 extends AProblem {
	public static int DESIRED_POSITION = 10001; // the desired prime's position

	public static void main(String[] args) {
		int num = 0; // the number we're currently checking
		int position = 0; // the last position of a prime
		int solution = 0; // the solution

		while (solution == 0) { // while we have no solution do:
			num++; // add a number
			if (isPrime(num)) { // if a number is a prime:
				position++; // we have a next prime in a position
				if (position == DESIRED_POSITION) { // if the position is the same as the one we want:
					solution = num; // this number is our solution!
				}
			}
		}
		System.out.println("The prime on " + DESIRED_POSITION + " position is: " + solution + "!"); // print the solution into the console!
	}
	
	// following methods are from Problem003.java!
	public static boolean isPrime(int n){ // is a number prime? (a method)
		if(n <= 1){ 
			return false; // all numbers smaller or equal to one are not prime
		}else if(n <= 3){ 
			return true; // 2 and 3 are primes
		}else{
			if (n % 2 == 0){ 
				return false; // any even number can't be a prime
			}
			for (int o = 3, max = getSqrt(n); o <= max; o += 2){ // for all the numbers (n) between 3 and their square root do:
				if (n % o == 0){ // if the number (n) is divisible by any value we're trying (o):
					return false; // it is not a prime!
				} 
			} // add 2 to the value (o) [maths => odd number + even number -> odd number; every odd number but 2 is not a prime]
			return true; // all numbers (n) that are not divisible by any value we were trying (o) are prime!
		}
	}
	
	public static int getSqrt(int n) { //gets a rounded square root of an integer
		return (int) Math.floor(Math.sqrt(n));
	}
}
