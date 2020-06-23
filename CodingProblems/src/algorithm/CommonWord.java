package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CommonWord {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		CommonWord cWord = new CommonWord();
		String res = cWord.mostCommonWord(paragraph, banned);
		System.out.println(res);
	}
	
    public String mostCommonWord(String paragraph, String[] banned) {
     
    	String[] words = paragraph.split(" ");
    	
    	Map<String, Integer> map = new HashMap<>();
    	
    	for (String word : words) {
    		String pureWord = word.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

    		for (String bannedWord : banned) {
    			if (pureWord.equals(bannedWord))
    				continue;
        		int count = map.getOrDefault(pureWord, 0);
        		map.put(pureWord, count + 1);
    		}
    	}
    	
    	int maxCount = 0;
    	String res = "";
    	for (String w : map.keySet()) {
    		maxCount = Math.max(map.get(w), maxCount);
    		if (maxCount == map.get(w))
    			res = w;
    	}
    	
    	return res;
    }
}
