package algorithm;

public class PalindromeTwo {

	public static void main(String[] args) {
		PalindromeTwo palindrome = new PalindromeTwo();
		boolean res = palindrome.isValidPalindrome("abca");
		System.out.println(res);
	}
	
	// given string is a valid palindrome 
	// if it is a palindrome after deleting at most one character
	public boolean isValidPalindrome(String s) {
		
		for (int i = 0; i < s.length() / 2; i++) {
			
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i; 
				
				return helper(s, i + 1, j) || helper(s, i , j - 1);
			}
		}
		return false;
	}
	
	private boolean helper(String s, int i, int j) {
		
		for (int k = i; k <= (j - i - k) / 2; k++) {
			
			if (s.charAt(k) != s.charAt(s.length() - k - i))
				return false;
		}
		return true;
	}
}
