package algorithm;

import java.util.HashSet;
import java.util.Set;

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

    public int longestPalindrome(String s) {
    	if (s.length() == 0)
    		return 0;
    	
    	Set<Character> set = new HashSet<>();
    	int count = 0;
    	
    	for (char c : s.toCharArray()) {
    		if (set.contains(c)) {
    			set.remove(c);
    			count++;
    		} else {
    			set.add(c);
    		}
    	}
    	
    	return !set.isEmpty() ? count * 2 + 1 : count * 2;
    }
}
