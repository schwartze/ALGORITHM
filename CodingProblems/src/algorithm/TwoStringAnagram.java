package algorithm;

public class TwoStringAnagram {
	
	public static void main(String[] args) {
		String s = "leetcode";
		String t = "practice";
		
		String s2 = "friend";
		String t2 = "family";
		
		String s3 = "anagram";
		String t3 = "mangaar";
		
		String s4 = "bab";
		String t4 = "aba";
		
		String s5 = "xxyyzz";
		String t5 = "xxyyzz";
		
		
		int steps = minSteps(s5, t5);
		System.out.println(steps);
	}
	
    public static int minSteps(String s, String t) {
    	int steps = 0;
    	int[] sLetters = new int[26];
    	int[] tLetters = new int[26];
    	
    	for (int i = 0; i < s.length(); i++) {
    		sLetters[s.charAt(i) - 'a']++;
    		tLetters[t.charAt(i) - 'a']++;
    	}
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (sLetters[s.charAt(i) - 'a'] > tLetters[s.charAt(i) - 'a']) {
    			steps += sLetters[s.charAt(i) - 'a'] - tLetters[s.charAt(i) - 'a'];
    			sLetters[s.charAt(i) - 'a'] = 0;
    		}
    	}
    	return steps;
    }
    
}
