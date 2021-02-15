package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringPattern {
	
	public static void main(String[] args) {
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
	
		List<String> res = findAndReplacePattern(words, pattern);
		
		for (String word : res)
			System.out.println(word);
	}
	
	/*
	 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
	 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
	 */
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		Map<Character, Character> map = new HashMap<>(); 
		List<String> res = new ArrayList<>();
		
		for (String word : words) {
			StringBuilder temp = new StringBuilder(word);
			map.clear();
			
			for (int i = 0; i < word.length(); i++) {
				
				if (map.containsKey(word.charAt(i))) {
					if (map.get(word.charAt(i)) != pattern.charAt(i))
						break;
				} else {
					if (map.containsValue(pattern.charAt(i)))
						break;
					map.put(word.charAt(i), pattern.charAt(i));
				}
				temp.setCharAt(i, map.get(word.charAt(i)));
			}
			if (pattern.equals(temp.toString())) 
				res.add(word);
		}
		return res;
	}
}
