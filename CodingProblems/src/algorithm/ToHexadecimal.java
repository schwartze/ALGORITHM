package algorithm;

import java.util.HashMap;

public class ToHexadecimal {

	public static void main(String[] args) {
		
		System.out.println(toHex(26));
	}
	
	public static String toHex(int n) {
		HashMap<Integer, Character> hexMap = new HashMap<Integer, Character>();
		hexMap.put(10, 'A');
		hexMap.put(11, 'B');
		hexMap.put(12, 'C');
		hexMap.put(13, 'D');
		hexMap.put(14, 'E');
		hexMap.put(15, 'F');
		
		int powerOf16 = 1;
		
		while (true) {
			
			if (n < powerOf16)
				break;
			
			powerOf16 *= 16;
		}
		String result = "";

		int num = n;
		while (true) {
			powerOf16 /= 16;
			
			int value = num / powerOf16;
			int remainder = num % powerOf16;
			
			if (value > 10)
				result += hexMap.get(value);
			else 
				result += value;
			
			if (remainder < 16) {
				result += hexMap.get(remainder);
				break;
			}
			
			num = remainder;
		}
		
		return result;
	}
}
