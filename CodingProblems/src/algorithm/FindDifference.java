package algorithm;

import java.util.HashSet;

public class FindDifference {

	public static void main(String[] args) {
		String s = "abde";
		String t = "abcde";
		
		System.out.println(findDifference(t, s));
	}
	
	public static char findDifference(String t, String s) {
		HashSet<Character> set = new HashSet<Character>();
		
		for (char c : s.toCharArray())
			set.add(c);
		
		char result = '\u0000';
		
		for (int i = 0; i < t.length(); i++) {
			
			if (!set.contains(t.charAt(i))) {
				result = t.charAt(i);
				break;
			}
		}
		
		return result;
	}
	
	public static char findTheDifference(String s, String t) {
		
		int charNum = t.charAt(s.length());
		
		for (int i = 0; i < charNum; i++) {
			charNum -= s.charAt(i);
			charNum += t.charAt(i);
					
		}
		
		return (char)charNum;
	}
}
