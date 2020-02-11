package algorithm;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
	}
	
	// #1: classic loop
	public static boolean isPerfectSquare(int number) {
		int value = 1;
		
		while (value < number) {
			 
			int output = value * value;

			if (output == number)
				return true;
			value++;
		}
		return false;
	}
	
	// #1: Newton Method
	public static boolean isPerfectSquare2(int num) {
		long x = num;
		
		while (x * x > num) {
			x = (x + num / x) >> 1;
		}

		return x * x == num;
	}
	
	// #3: binary search method
	public static boolean isPerfectSquare3(int num) {
		int low = 1;
		int high = num;
		
		while (low <= high) {
			long mid = (low + high) >>> 1;
			
			if (mid * mid == num) {
				return true;
		
			} else if (mid * mid < num) {
				low = (int) mid + 1;
			
			} else {
				high = (int) mid - 1;
			}
		}
		return false;
	}
}
