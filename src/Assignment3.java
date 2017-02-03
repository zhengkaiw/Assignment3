/**
 * Created by Rose on 1/27/17. Assignment for your lecture 3. Please finish all
 * the questions under 'Assignment'. Please try to think the extra credit
 * questions. The deadline of this assignment is 02/04/2017 23:59 PST. Please
 * feel free to contact me for any questions. Please write your comments about
 * this assignment in the end.
 */

public class Assignment3 {
	/**
	 * Given an array, reverse the elements within this array and print the
	 * result eg, given{1,2,3,4}, print{4,3,2,1}
	 */
	public void reverseArray(int[] nums) {
		// write your code here

		for (int i = nums.length; i > 0; i--) {
			System.out.print(nums[i - 1] + " ");
		}

	}

	/**
	 * Given a non-negative integer represented as a non-empty array of digits,
	 * plus one to the integer. Assume the integer do not contain any leading
	 * zero, except the number 0 itself. The digits are stored such that the
	 * most significant digit is at the head of the array. eg, given {1,2,9},
	 * return{1,3,0}.
	 */
	public int[] plusOne(int[] digits) {
		// write your code here

		int l = digits.length;
		int in = 0;
		int c = 0;

		for (int i = l; i > 0; i--) {
			in += (digits[i - 1] * Math.pow(10, c));
			c++;
		}
		c = 0;
		in += 1;

		int[] op = new int[(int) Math.ceil(Math.log10(in))];

		for (int i = op.length; i > 0; i--) {
			int ln = (int) in / ((int) Math.pow(10, (i - 1)));
			op[c] = ln;
			c++;
			in -= ln * ((int) Math.pow(10, (i - 1)));
		}
		return op;
	}

	/**
	 * Write a program that takes an integer as input and returns all the primes
	 * between 1 and that integer(inclusive). eg, input is 18, you should
	 * return{2,3,5,7,11,13,17}
	 */
	public int[] generatePrimes(int n) {
		// write your code here

		int count = 0;
		int count2 = 0;

		for (int i = 1; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		int[] op = new int[count];

		for (int i = 1; i <= n; i++) {
			if (isPrime(i)) {
				op[count2] = i;
				count2++;
			}
		}

		return op;
	}

	public boolean isPrime(int n) {
		// write your code here

		if (n <= 1) {
			return false;
		} else {
			for (int i = 2; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Assume you have a method isSubstring which checks if one word is a
	 * substring of another. Given two strings, s1 and s2, write a program to
	 * check if s2 is a rotation of s1, using only one call to isSubstring eg,
	 * "pineapple" is a rotation of "neapplepi"
	 */
	public boolean isRotation(String s1, String s2) {
		// write your code here

		if (s1.length() != s2.length()) {
			return false;
		}

		String s3 = new String();

		s3 = s1 + s1;
		return isSubstring(s3, s2);
	}

	public boolean isSubstring(String s1, String s2) {

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		boolean judge = false;
		int count = 0;

		for (int i = 0; i < (c1.length - c2.length + 1); i++) {
			count = 0;
			for (int j = 0; j < c2.length; j++) {
				if (c1[i + j] != c2[j]) {
					count += 1;
				}
			}
			if (count == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given two strings, write a method to decide if one is a permutation of
	 * the other hint: the comparison is case sensitive and whitespace is
	 * significant
	 */
	public boolean isPermutation(String s1, String s2) {
		// write your code here

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		boolean judge = true;

		if (c1.length != c2.length) {
			return false;
		}

		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i] == c2[j]) {
					c2[j] = '?';
					continue;
				}
			}
		}

		for (char cc : c2) {
			if (cc != '?') {
				judge = false;
			}
		}
		return judge;
	}

	/**
	 * Write a program to implement encoding and decoding string. The rule is
	 * simple: encode successive repeated characters by the repetition count and
	 * the character. For example, the input of encoding() is "aaaabcccaa", you
	 * should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee".
	 * Assume the string to be encoded consists of letters of the alphabet, with
	 * no digits, and the string to be decoded is a valid encoding.
	 */
	public static String encoding(String s) {
		// write your code here

		char[] c = s.toCharArray();

		String code = new String();

		int count = 1;

		for (int i = 1; i < c.length; i++) {
			if (c[i] != c[i - 1]) {
				if (i == 1) {
					code = code + 1 + c[0];
					count = 1;
				} else {
					code = code + count + c[i - 1];
					count = 1;
				}
			} else {
				count++;
			}
		}
		code = code + count + c[c.length - 1];
		return code;
	}

	public static String decoding(String s) {
		// write your code here

		char[] c = s.toCharArray();

		String code = new String();

		for (int i = 1; i < c.length; i += 2) {
			for (int j = 0; j < ((int) c[i - 1] - (int) ('0')); j++) {
				code = code + c[i];
			}
		}
		return code;
	}

	// Extra Credit
	/**
	 * Given an m x n 2D matrix representing an image. Rotate the image by 90
	 * degrees (clockwise). For example, given 1 2 3 , return 7 4 1 4 5,6 8 5 2
	 * 7,8,9 9 6 3 tip: image could be a square or a rectangle.
	 */
	public void rotate(int[][] matrix) {
		// write your code here

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = m; j > 0; j--) {
				System.out.print(matrix[j - 1][i] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Given a string containing just the characters '(', ')', return the count
	 * of valid parentheses. If the input is not valid, return -1. A valid
	 * parentheses is "()". For example, given "(())", return 2; given "(()))",
	 * return -1.
	 */
	public int countValidParentheses(String s) {
		// write your code here

		int m = 0, n = 0;

		char[] c = s.toCharArray();

		for (char cc : c) {
			if (cc == '(') {
				m++;
			} else if (cc == ')') {
				n++;
			}
		}

		if (m != n) {
			return -1;
		} else {
			return m;
		}

	}

	/**
	 * Write anything you think about this assignment here. Easy? Difficult? Too
	 * many questions? Less fun? You could write any comments here
	 */
	
	/* I think for most parts of my classmates who never learned about Java, this
	 * assignment is pretty difficult for them. When I first learned Java, my task
	 * is basic. The logic is simple so that it is easy for us to practice the new 
	 * functions we just learned. So I suggest you can design some basic tasks and 
	 * some questions from leetcode for extra credit. As for me, I think these assignments
	 * are perfect. Although they are a little bit hard, they are all relative with 
	 * the lecture we just took. I think if it's OK, you can give us some feedback about
	 * our code. About logic, brevity. Let us know the problem of our codes. And this is
	 * just the suggestion. If you are busy, just ignore this.
	 */
}