package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class WordsInDictionary {

	public static void main(String[] args) {
		String[] words = {"w","wo","wor","worl", "world"};
		String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words3 = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
		WordsInDictionary dic = new WordsInDictionary();
		String str = dic.longestWord2(words2);
		System.out.println(str);
	}
	
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet<>();

        for (String word: words) wordset.add(word);
        
        for (String word: words) {
        
        	if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
            
                for (int k = 1; k < word.length(); ++k) {
                
                	if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }    
        }
        return ans;
    }
    
    public String longestWord2(String[] words) {
    	
		char first = words[0].charAt(0);
    	List<HashSet<String>> list = new ArrayList<>();
    	
    	int max = Integer.MIN_VALUE;
    	String res = "";
    	int len = 0;
    	
    	for (String word : words) {
    		HashSet<String> set = new HashSet<>();

    		if (word.charAt(0) != first) {
    			first = word.charAt(0);
    		}
			set.add(word);
			String str = helper(set);

			if (str.length() > max)
				res = str;
			max = Math.max(max, str.length());
    	}
      	
    	return res;
    }
    
    private String helper(HashSet<String> set) {
    	
    	String temp = "";
    	
    	for (String word : set) {
    		
    		if (!temp.equals(word.substring(0, temp.length())))
    			continue;
    		
    		temp = word;
    	}
    	return temp;
    }
    
    
    
    
    
    
    
    
    
    
}
