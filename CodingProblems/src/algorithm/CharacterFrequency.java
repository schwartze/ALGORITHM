package algorithm;

public class CharacterFrequency {

	public static void main(String[] args) {
		String[] queries = {"bbb", "cc"};
		String[] words = {"a", "aa", "aaa", "aaaa"};
		CharacterFrequency charFreq = new CharacterFrequency();
		int[] res = charFreq.numSmallerByFrequency(queries, words);
		
		for (int n : res)
			System.out.println(n);
	}
	/*
	 * Let's define a function f(s) over a non-empty string s, 
	 * which calculates the frequency of the smallest character in s. 
	 * For example, if s = "dcce" then f(s) = 2 because the smallest character 
	 * is "c" and its frequency is 2.
	 * Now, given string arrays queries and words, 
	 * return an integer array answer, where each answer[i] is 
	 * the number of words such that f(queries[i]) < f(W),
	 * where W is a word in words.
	 */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
    	int[] res = new int[queries.length];
    	
    	for (int i = 0; i < queries.length; i++) {
    		int queryFreq = getSmallestFreq(queries[i]);

    		for (String word : words) {
    			
    			if (queryFreq > word.length())
    				continue;
    			
    			int wordFreq = getSmallestFreq(word);
    			if (wordFreq > queryFreq)
    				res[i]++;
    		}
    	}
    	return res;
    }
    
    private int getSmallestFreq(String str) {
    	int[] chars = new int[26];
    	int smallest = Integer.MAX_VALUE;
    	
    	for (char c : str.toCharArray()) {
    		chars[c - 97]++;
    		smallest = Math.min(smallest, c - 97);
    	}
    	return chars[smallest];
    }
}
