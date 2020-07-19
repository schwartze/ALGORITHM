package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UncommonWords {

	public static void main(String[] args) {
		String A = "This apple is sweet";
		String B = "This apple is sour";
		
		String C = "apple apple";
		String D = "banana";
		
		
		UncommonWords uWords = new UncommonWords();
		String[] res = uWords.uncommonFromSentences(C, D);
		
		for (String word : res)
			System.out.print(word + ", ");
		
	}
	
	// uncommon word 
	// condition #1: should appear once in one sentence
	// condition #2: does not appear in the other sentence
	
    public String[] uncommonFromSentences(String A, String B) {
     
    	HashMap<String, Integer> aMap = fillMap(A);
    	HashMap<String, Integer> bMap = fillMap(B);
    	
    	List<String> list = new ArrayList<>();
    	
    	compareValues(aMap, bMap, list);
    	compareValues(bMap, aMap, list);
    	
    	return list.toArray(new String[list.size()]);
    }
    
    private HashMap<String, Integer> fillMap(String sentence) {
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	for (String word : sentence.split(" ")) {
    		int count = map.getOrDefault(word, 0);
    		map.put(word, count + 1);
    	}
    	return map;
    }

    private void compareValues(HashMap<String, Integer> aMap, HashMap<String, Integer> bMap, List<String> list) {
    	
		for (String word : aMap.keySet()) {
		    		
    		if (aMap.get(word) > 1 || bMap.containsKey(word)) 
    			continue;
    		
    		list.add(word);
		}
    }
}
