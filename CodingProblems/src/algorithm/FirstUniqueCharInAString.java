package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstUniqueCharInAString {

	public static void main(String[] args) {
		System.out.println(firstUniqueChar("leetcode"));
	}
	
	public static int firstUniqueChar(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : str.toCharArray()) {
			int count = map.getOrDefault(c, 0);
			map.put(c, ++count);
		}
		
		for (int i = 0; i < str.length(); i++) {
			
			if (map.get(str.charAt(i)) != null && (map.get(str.charAt(i)) == 1))
				return i;
		}
		return 0;
	}
}
