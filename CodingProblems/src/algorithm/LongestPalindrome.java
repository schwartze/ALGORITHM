package algorithm;

public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "sanswerabcdcba";
		int res = getLongestPalindromeLength(s);
		System.out.println(res);
	}
	
	public static int getLongestPalindromeLength(String s) {
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			
			char targetChar = s.charAt(i);
			if (s.lastIndexOf(targetChar) == i || s.lastIndexOf(targetChar) < -1)
				continue;

			int endIdx = s.lastIndexOf(targetChar);			
			if (isPalindrome(s, i, endIdx)) {
				res = endIdx - i + 1;
				break;
			}
		}
		return res;
	}
	
	private static boolean isPalindrome(String word, int startIdx, int endIdx) {
		boolean result = true;
		
		for (int i = startIdx + 1, j = endIdx - 1; i <= j; i++, j--) {
			if (word.charAt(i) != word.charAt(j)) {
				result = false;
				break;
			}
		}
		
		return result;
	}
}
