package algorithm;

public class PowerOfFour {

	public static void main(String[] args) {
		
		System.out.println(isPowerOfFour4(16));
	}
	
	// #1: loop iteration
	public static boolean isPowerOfFour(int n) {
		
		if (n == 0)
			return false;
		
		while (n % 4 == 0) {
			
			n /= 4;
		}
		
		return n == 1;
	}
	
	// #2: Regular Expression
	public static boolean isPowerOfFour2(int n) {
		
		String strValue = Integer.toString(n, 4);
		
		boolean result = strValue.matches("^10*$");
		
		return result;
	}
	
	// #3: Math Logarithm
	public static boolean isPowerOfFour3(int n) {
		
		int value = (int) ( Math.log(Integer.MAX_VALUE) / Math.log(4));
		
		int powerOf = 1;
		
		for (int i = 1; i <= value; i++) {
			powerOf *= 4;
		}
		
		return n > 0 && powerOf % n == 0;
	}
	
	// #4: Bit operator
	public static boolean isPowerOfFour4(int n) {
		
		// first part: check if the given n is greater than 0.
		// middle part : use & bit operator to check if 
		// 				all numbers are 0 except first 1.
		// last part : use hexadecimal (1010 * 8) to check if 
		// 				1 is in place.
		return n > 0 && (n&(n-1)) == 0 && (n & 0x55555555) != 0;
	}
}
