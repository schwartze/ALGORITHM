package algorithm;

public class Subsequence {

	public static void main(String[] args) {
		String t = "abdhgc";
		String s = "abc";
		
		System.out.println(isSubsequence(s, t));
		
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
}
