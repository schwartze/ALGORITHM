package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching {

	public static void main(String[] args) {
		String[] words = {"blue", "green", "bu"};
		List<String> res = stringMatching(words);
		
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
    			if (key.contentEquals(k))
    				continue;
    			
    			if (key.indexOf(k) > 0) 
    				res.add(k);
    		}
    	}
    	return res;
    }
    
}
