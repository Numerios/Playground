/* Playground - Java - Project Euler
 *  
 * Problem 004
 * http://projecteuler.net/problem=4
 * 
 * "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 *  Find the largest palindrome made from the product of two 3-digit numbers."
 */
public class Problem004 extends AProblem {
	// I think there could be some other (better) solution that I just can't see...
	public static int DIGITS = 3; // Number of digits we're checking; warning, number greater than 4 is VERY resource heavy
	public static int SMALLEST_NUMBER = (int) Math.pow(10, DIGITS - 1); // The smallest number (we're starting our for loops on it)
	public static int GREATEST_NUMBER = (int) Math.pow(10, DIGITS); // The largest number (we're ending our for loops on it)

	public static void main(String[] args) {
		int finalPalindrome = 0;
		for (int i = SMALLEST_NUMBER; i < GREATEST_NUMBER; i++) { // for all values that have DIGITS digits (i) do:
			for (int j = SMALLEST_NUMBER; j < GREATEST_NUMBER; j++) { // for all values that have DIGITS digits (j) do:
				if (isPalindrome(i * j)) { // if i times j is a palindrome:
					if (finalPalindrome < i * j) { // if the current palindrome is bigger than the one saved in finalPalindrome:
						finalPalindrome = i * j; // save the current palindrome as finalPalindrome!
					}
				}
			}
		}
		System.out.println("The largest palindrome is: " + finalPalindrome // print the largest palindrome
				+ "!");
	}

	public static boolean isPalindrome(int n) { // method for checking if the integer (n) is a palindrome
		String nString = Integer.toString(n); // convert the integer (n) into a string (nString) 
		String revString = new StringBuilder(nString).reverse().toString(); // reverse the previous string (nString) into another string (revString)
		if (nString.equals(revString)) // if both strings are the same (nString and revString):
			return true; // yes, the number (n) is a palindrome!
		else // else:
			return false; // this number is not a palindrome!
	}
}
