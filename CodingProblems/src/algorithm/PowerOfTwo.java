package algorithm;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo3(8));
	}
	
	public static boolean isPowerOfTwo(int number) {
		
		if (number == 0)
			return true;
		
		int num = 1;
		
		for (int i = 0; num < number; i++) {

			if (num == number)
				return true;

			num *= 2;
		}
		
		return false;
	}
	
	public static boolean isPowerOfTwo2(int number) {
		
		while (number >= 0) {
			
			number = number / 2;

			if (number == 1)
				return true;
			
			if (number % 2 != 0)
				break;
		}
		
		return false;
	}
	
	public static boolean isPowerOfTwo3(int number) {
		if (number <= 0)
			return false;
		
		return (number&(number-1)) == 0;
	}
	
	public static boolean isPowerOfTwo4(int number) {
		if (number <= 0)
			return false;
		
		return Integer.bitCount(number) == 1;
	}
}
