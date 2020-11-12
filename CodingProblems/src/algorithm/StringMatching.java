package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching {

	public static void main(String[] args) {
		String[] words = {"leetcoder","leetcode","od","hamlet","am"};
 		List<String> res = stringMatching3(words);
 		
		for (String str : res)
			System.out.println(str);
	}
	
    public static List<String> stringMatching(String[] words) {
    	List<String> res = new ArrayList<>();
    	Set<String> wordSet = new HashSet<>();
    	
    	for (String word : words) 
    		wordSet.add(word);
    	
    	for (String key : wordSet) {
    		
    		for (String k : wordSet) {
    			if (k.equals(key))
    				continue;
    			
    			if (key.indexOf(k) >= 0 && !res.contains(k)) 
    				res.add(k);
    		}
    	}
    	return res;
    }
    
    public static List<String> stringMatching2(String[] words) {
    	List<String> res = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	
    	for (String word : words) 
    		sb.append(word + ",");
    	
    	String connectedStr = sb.toString();
    	
    	for (String word : words) {
    		int firstIdx = connectedStr.indexOf(word);
    		int lastIdx = connectedStr.lastIndexOf(word);
    		
    		if (firstIdx >= 0 && lastIdx > firstIdx) 
    			res.add(word);
    	}
    	return res;
    }
    
    public static List<String> stringMatching3(String[] words) {
    	List<String> res = new ArrayList<>();
    	Arrays.sort(words, (a, b) -> a.length() < b.length() ? -1 : 1);
    	
    	for (int i = 0; i < words.length; i++) {
    		int j = i + 1;
    		
    		while (j < words.length) {
    			if (words[j++].indexOf(words[i]) >= 0) {
    				res.add(words[i]);
    				break;
    			}
    		}
    	}
    	
    	return res;
    }
}
