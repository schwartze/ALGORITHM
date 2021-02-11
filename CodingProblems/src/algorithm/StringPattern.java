package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		List<String> res = new ArrayList<>();
		
		int prev = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == prev) {
				map.put(i - 1, map.get(i - 1) + 1);
				continue;
			}
				
			map.put(i, 1);
			prev = pattern.charAt(i);
		}
		
		for (int i = 0; i < words.length; i++) {
			
			for (int j = 0; j < words[i].length(); j++) {
				int count = map.get(j);
				int value = words[i].charAt(j);
				boolean samePattern = true;
				
				for (int k = 0; k < count; k++) {
					if (value != words[i].charAt(k)) {
						samePattern = false;
						break;
					}
				}
				if (samePattern)
					res.add(words[i]);
			}
		}
		return res;
    }
}
