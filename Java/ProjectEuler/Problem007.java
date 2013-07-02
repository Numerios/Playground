/* Playground - Java - Project Euler
 *  
 * Problem 007
 * http://projecteuler.net/problem=7
 * 
 * "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *  What is the 10 001st prime number?"
 */
public class Problem007 extends AProblem {
	public static int DESIRED_POSITION = 10001;

	public static void main(String[] args) {
		int num = 0;
		int position = 0;
		int solution = 0;

		while (solution == 0) {
			num++;
			if (isPrime(num)) {
				position++;
				if (position == DESIRED_POSITION) {
					solution = num;
				}
			}
		}
		System.out.println(solution);
	}
	
	// following methods are from Problem003.java!
	public static boolean isPrime(int n){
		if(n <= 1){
			return false;
		}else if(n <= 3){
			return true;
		}else{
			if (n % 2 == 0){
				return false;
			}
			for (int o = 3, max = getSqrt(n); o <= max; o += 2){
				if (n % o == 0){
					return false;
				}
			}
			return true;
		}
	}
	
	public static int getSqrt(int n) { //gets a rounded square root of an integer
		return (int) Math.floor(Math.sqrt(n));
	}
}
