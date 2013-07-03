import java.util.Arrays;

/* Playground - Java - Project Euler
 *  
 * Problem 010
 * http://projecteuler.net/problem=10
 * 
 * "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *  Find the sum of all the primes below two million."
 */
public class Problem010 extends AProblem {
	public static int LIMIT = 2000000; // our search limitation

	public static void main(String[] args) {
		boolean[] primes = Arrays.copyOf(arePrime(LIMIT - 1), LIMIT); // try out if all primes within limit are primes (throws them into an array)
		long solution = 0; // our solution (it gets really high so it'll be stored in a long)
		for (int n = 0; n < primes.length; n++) { // for all numbers between 0 and the length of primes (basically, LIMIT):
			if(primes[n] == true) { // if the current number (n) is a prime
				solution += n; // add it into the sum (solution)
			}
		}
		System.out.println("The sum of all primes below " + LIMIT + " is: " + solution + "!"); // print the results into the console
	}

	public static boolean[] arePrime(int primeLimit) { // Sieve of Eratosthenes ^^
		boolean[] prime = new boolean[primeLimit + 1]; // init the array for our primes
		Arrays.fill(prime, Boolean.TRUE);  // fill the array with all true
		int max = getSqrt(primeLimit); // get the rounded square root of our search limit (primeLimit)

		prime[0] = false; // 0 is never a prime
		prime[1] = false; // 1 is never a prime

		for (int i = 2; i <= max; i++) { // for all numbers in the first row (between 2 and max) do:
			if (prime[i]) { // if that number is prime:
				for (int j = i * i; j <= primeLimit; j += i) { // try finding if the number is divisible
					prime[j] = false; // if it is divisible, it's not a prime
				}
			}
		}
		return prime; // return all the values of the primes
	}

	// from Problem003.java!
	public static int getSqrt(int n) { // gets a rounded square root of an  integer
		return (int) Math.floor(Math.sqrt(n));
	}
}