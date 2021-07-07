package algorithm;

public class PalindromeII {
	
	public static void main(String[] args) {
		String s = "aba";
		String s2 = "abca";
		String s3 = "abc";
		String s4 = "tebbem";
		String s5 = "acbca";
		
		boolean res = validPalindrome(s5);
		System.out.println(res);
	}

    public static boolean validPalindrome(String s) {
    	
    	for (int i = 0; i < s.length(); i++) {
    		StringBuilder sb = new StringBuilder(s);
    		sb.deleteCharAt(i);
    		if (isPalindrome(sb.toString()))
    			return true;
    	}
    	
    	return false;
    }
    
    private static boolean isPalindrome(String s) {
    	int pointIdx = s.length() % 2 == 0 ? 0 : 1;
    	
    	String leftHalf = s.substring(0, s.length() / 2);
    	StringBuilder sb = new StringBuilder(s.substring(s.length() / 2 + pointIdx));
    	
    	return leftHalf.equals(sb.reverse().toString());
    }
}
