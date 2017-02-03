public class Assignment3Test {

	public static void main(String[] args) {

		Assignment3 as = new Assignment3();

		int[] a = { 1, 2, 3, 4 };
		int[][] b = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		String s = "(((()))";
		String c = "aaabbccccaa";
		String dc = "3a2b4c2a";
		int prime = 18;
		int[] d = { 1, 2, 8 };
		String s1 = "pineapple";
		String s2 = "neapplepi";
		String s3 = "apple";

		as.reverseArray(a);
		System.out.println();
		
		for (int i = 0; i < as.plusOne(d).length; i++) {
			System.out.print(as.plusOne(d)[i] + " "); 
		}
		System.out.println();
		
		for (int i = 0; i < as.generatePrimes(prime).length; i++) {
			System.out.print(as.generatePrimes(prime)[i] + " "); 
		}
		System.out.println();
		
		System.out.println(as.isRotation(s1, s2));
		
		System.out.println(as.isSubstring(s1, s3));
		System.out.println(as.isPermutation(s1, s2));
		
		System.out.println(as.encoding(c));
		System.out.println(as.decoding(dc));
		
		as.rotate(b);
		
		System.out.println(as.countValidParentheses(s));
	}
}