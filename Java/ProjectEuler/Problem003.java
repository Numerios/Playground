import java.util.ArrayList;

/* Playground - Java - Project Euler
 *  
 * Problem 003
 * http://projecteuler.net/problem=3
 * 
 * "The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?"
 */
public class Problem003 extends AProblem {
	public static long VALUE = 600851475143L;

	public static void main(String[] args) {
		String finalSolution = null; // our solution (the largest prime factor)
		ArrayList<String> solutionList = new ArrayList<String>(); // an ArrayList that saves any prime factors
		if (!isPrime(VALUE)) { // only continue when VALUE is not prime
			for (int i = 2; i <= getSqrt(VALUE); i++) { // for every number (i) that is smaller or equal to square root of the VALUE do:
				if (VALUE % i == 0) { // if VALUE is divisible by that number (i):
					if (isPrime(i)) { // if the number (i) is prime:
						solutionList.add(Integer.toString(i)); // the number (i) is one of our solutions and is added into the list as a string!
					}
				}
			}
		}
		if (solutionList.isEmpty()) { // if there is no solution (a prime factor) in the list:
			System.out.println("Given value is prime itself!"); // given VALUE is divisible only by itself and one, meaning that it is prime itself!
		} else { // if there is a solution present:
			System.out.print("The prime factors of " + VALUE + " are: "); // print this text into console with initial VALUE
			for (int i = 0; i < solutionList.size(); i++) { // for any value present in the list do:
				String solutions = solutionList.get(i); // convert i-th value into a string "solutions"
				finalSolution = solutions; // string "solutions" could be our final solution so let's save it into "finalSolution" (it'll overwrite itself in every circle)
				System.out.print(solutions); // print the solution into console
				if (i < solutionList.size() - 1) { // if the value is not the last in the list:
					System.out.print(", "); // print a comma!
				} else { // else:
					System.out.println("!"); // print an exclamation mark and end the line!
				}
			}
			System.out.println("So the largest prime factor is: " // print a new line containing the final solution (the largest prime factor)!
					+ finalSolution + "!");
		} 
	}
	
	public static boolean isPrime(long l){ // checks if initial value (l) is prime
		if(l <= 1){ // all numbers smaller or equal to 1 are not prime!
			return false;
		}else if(l <= 3){ // all numbers between 1 and 3 (3 included) are primes!
			return true;
		}else{
			if (l % 2 == 0){ // all numbers divisible by 2 are not primes!
				return false;
			}
			for (long m = 3, max = getSqrt(l); m <= max; m += 2){ // for all numbers that are between our value (l) and the square root of our value (l) do:
				if (l % m == 0){ // all values (l) that are divisible by any of our numbers (m) are not primes!
					return false;
				}
			}
			return true; // all values (l) that were not divided by any of our numbers (m) are primes!
		}
	}

	public static long getSqrt(long l) { //gets a rounded square root of a long
		return (long) Math.floor(Math.sqrt(l));
	}
}
