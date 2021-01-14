package algorithm;

public class ConsistentStrings {

	public static void main(String[] args) {
		String allowed = "cad"; 
		String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
		
		int res = countConsistentStrings(allowed, words);
		System.out.println(res);
	}
	// You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
	// Return the number of consistent strings in the array words.
    public static int countConsistentStrings(String allowed, String[] words) {
    	int[] allowedArray = new int[26];
    	int count = 0;
    	
    	for (char c : allowed.toCharArray())
    		allowedArray[c - 'a']++;
    	
    	for (String word : words) {
    		boolean consistent = true;
    		
    		for (char c : word.toCharArray()) {
    			if (allowedArray[c - 'a'] == 0) {
    				consistent = false;
    				break;
    			}
    		}
    		if (consistent)
    			count++;
    	}
    	return count;
    }
}
