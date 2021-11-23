package algorithm;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "ac";
		String res = longestPalindrome(s);
		System.out.println(res);
	}
	
    public static String longestPalindrome(String s) {
    	int maxLength = Integer.MIN_VALUE;
    	String res = "";
    	
    	for (int i = 0; i < s.length(); i++) {
    		char curr = s.charAt(i);
    		int lastIdx = s.lastIndexOf(curr);
    		
    		if (isPalindrome(s.substring(i, lastIdx + 1))) {
    			if (lastIdx - i + 1 > maxLength) {
    				maxLength = lastIdx - i + 1;
    				res = s.substring(i, lastIdx + 1);
    			}
    		}
    	}
    	return res;
    }
    
    private static boolean isPalindrome(String s) {
    	return new StringBuilder(s).reverse().toString().equals(s);
    }
}
