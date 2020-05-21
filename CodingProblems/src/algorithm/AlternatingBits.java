package algorithm;

public class AlternatingBits {

	public static void main(String[] args) {
		AlternatingBits aBits = new AlternatingBits();
		boolean res = aBits.isAlternating(5);
		System.out.println(res);
	}
	// check if given number n has alternating bits 
	// meaning that two adjacent bits always have different values 
	
	// #1: using for statement
	public boolean isAlternating(int n) {
		String bitStr = Integer.toBinaryString(n);
		
		char prev = '\u0000';
		for (char s : bitStr.toCharArray()) {
			
			if (s == prev)
				return false;
			prev = s;
		}
		
		return true;
	}
	
	// #2: using bit operation
	public boolean hasAlternatingBits(int n) {
		
		return ((n & (n >> 1)) == 0) && (n & n >> 2) == (n >> 2);
	}
}
