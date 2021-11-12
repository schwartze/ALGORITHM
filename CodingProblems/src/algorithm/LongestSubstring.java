package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	Set<Character> set = new HashSet<>();
    	int max = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char curr = s.charAt(i);
    		
    		if (set.contains(curr)) {
    			max = Math.max(max, set.size());
    			set.clear();
    			continue;
    		}
    		set.add(s.charAt(i));
    	}
    	
    	return Math.max(max, set.size());
    }
}
