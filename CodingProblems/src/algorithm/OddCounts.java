package algorithm;

public class OddCounts {

	public static void main(String[] args) {
		
	}
	// Given an integer n, return a string with n characters 
	// such that each character in such string occurs an odd number of times.
    public static String generateTheString(int n) {
    	StringBuilder sb = new StringBuilder();
    	
    	boolean isEven = n % 2 == 0;
    	// if n is even 
    	// a * (n - 1) + b
    	if (isEven) {
    		
    		for (int i = 0; i < n - 1; i++) 
    			sb.append("a");
    		sb.append("b");
    	} else {
        	// if n is odd
        	// a * n
    		for (int i = 0; i < n; i++)
    			sb.append("a");
    	}
    	return sb.toString();
    }
}
