package algorithm;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat dog dog";
		
		// System.out.println(hasSamePattern(pattern, str));
		
		System.out.println(wordPattern(pattern, str));
	}
	
	public static boolean hasSamePattern(String pattern, String str) {
		
		// put pattern into map and give each letter an index
		HashMap<String, Integer> pMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < pattern.length(); i++) {
			
			if (!pMap.containsKey(pattern.charAt(i) + ""))
				pMap.put(pattern.charAt(i) + "", i);
		}
		
		// put indices of pattern into int array 
		int[] pArray = new int[pattern.length()];
		
		for (int i = 0; i < pattern.length(); i++) {
			pArray[i] = pMap.get(pattern.charAt(i) + "");
		}
		
		// put each word into Map after splitting the given string by space: " "
		String[] strArray = str.split(" ");
		HashMap<String, Integer> sMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < strArray.length; i++) {

			if (!sMap.containsKey(strArray[i]))
				sMap.put(strArray[i], i);
		}
		
		// put indices of each word into int array 
		int[] sArray = new int[strArray.length];
		
		for (int i = 0; i < strArray.length; i++) {
			sArray[i] = sMap.get(strArray[i]);
		}
		
		
		// check if two arrays are the same 
		for (int i = 0; i < pArray.length; i++) {
			
			if (pArray[i] != sArray[i])
				return false;
		}
		
		return true;
	}
	
	public static boolean wordPattern(String pattern, String str) {
	    String[] words = str.split(" ");

	    if (words.length != pattern.length())
	        return false;
	    
	    // declare Map without type
	    Map index = new HashMap();
	 
	    for (Integer i = 0; i < words.length; ++i) {
	    	
	    	// map.put returns the previous value of associated key 
	    	if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    }
	    
	    return true;
	}
}
