package algorithm;

import java.util.Stack;

public class Subsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "abdhgc";

		String s2 = "abc";
		String t2 = "ahbgdc";

		String s3 = "axc";
		String t3 = "ahbgdc";
		
		String s4 = "";
		String t4 = "ahbgdc";
		
		String s5 = "b";
		String t5 = "abc";
		
		
		System.out.println(isSubsequence2(s5, t5));
	}
	
	// method telling if s is a subsequence of t
	// - the order of subsequence s in t matters
	public static boolean isSubsequence(String s, String t) {
		
		int indexS = 0;
		int indexT = 0;
		
		while (indexT < t.length()) {
			
			if (s.charAt(indexS) == t.charAt(indexT)) {
				
				indexS++;
				
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		
		return false;
	}

	
	public static boolean isSubsequence2(String s, String t) {
		if (s.isEmpty())
			return true;
		
		if (t.isEmpty())
			return false;
		
		Stack<Character> stack = new Stack<>();
		int sIdx = 0;
		
		for (int i = 0; i < t.length() && sIdx < s.length(); i++) {
			
			if (t.charAt(i) != s.charAt(sIdx)) 
				continue;

			stack.push(t.charAt(i));
			sIdx++;
		}
		return sIdx == s.length();
	}
}
