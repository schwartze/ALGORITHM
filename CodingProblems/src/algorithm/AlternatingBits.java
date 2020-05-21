package algorithm;

public class AlternatingBits {

	public static void main(String[] args) {
		AlternatingBits aBits = new AlternatingBits();
		boolean res = aBits.isAlternating(5);
		System.out.println(res);
	}
	// check if given number n has alternating bits 
	// meaning that two adjacent bits always have different values 
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
}
