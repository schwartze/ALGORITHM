package algorithm;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

	public static void main(String[] args) {
		String[] words = {"apple", "app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		
		AlienDictionary aDictionary = new AlienDictionary();
		boolean res = aDictionary.isAlienSorted(words, order);
		System.out.println(res);
	}
	
	/* 
	 * In an alien language, surprisingly they also use english lowercase letters, 
	 * but possibly in a different order. 
	 * The order of the alphabet is some permutation of lowercase letters.
	 * Given a sequence of words written in the alien language, 
	 * and the order of the alphabet, return true if and only if 
	 * the given words are sorted lexicographicaly in this alien language.
	 */
    public boolean isAlienSorted(String[] words, String order) {
     
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < order.length(); i++)
    		map.put(order.charAt(i), i);
    	
    	for (int i = 0; i < words.length - 1; i++) {
    		String word1 = words[i];
    		String word2 = words[i + 1];

    		if (word1.length() < word2.length()) {
    			
    			for (int j = 0; j < word1.length();) {
    				
    				if (map.get(word1.charAt(j)) < map.get(word2.charAt(j)))
    					break;
    				else
    					j++;
    				
    				if (j < word2.length() || map.get(word1.charAt(j)) > map.get(word2.charAt(j)))
    					return false;
    			} 
    		} else {
    			for (int j = 0; j < word2.length(); j++) {
    				
    				if (map.get(word1.charAt(j)) < map.get(word2.charAt(j)))
    					break;
    				else
    					j++;
    			
    				if (j < word1.length() || map.get(word1.charAt(j)) > map.get(word2.charAt(j)))
    					return false;
    			}
    		}
    	}
    	
    	return true;
    }
}
