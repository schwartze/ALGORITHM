package algorithm;

public class RotateString {

	public static void main(String[] args) {
		String A = "abcde";
		String B = "cdeab";
		
		RotateString rotate = new RotateString();
		boolean res = rotate.rotateString(A, B);
		System.out.println(res);
	}
	
	// A shift on A consists of taking string A 
	// and moving the leftmost character to the rightmost position. 
	// Return True if and only if A can become B after some number of shifts on A.
	public boolean rotateString(String A, String B) {
    	
    	StringBuffer temp = new StringBuffer(A);

    	for (int i = 0; i < A.length(); i++) {
    		temp.append(temp.charAt(0));
    		temp.deleteCharAt(0);
    		
    		if (temp.toString().equals(B))
    			return true;
    	}
    	
    	return false;
    }
	
}
