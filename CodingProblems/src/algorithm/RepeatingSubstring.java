package algorithm;

public class RepeatingSubstring {

	public static void main(String[] args) {
		String sequence = "ababc", word = "ab";
		String sequence2 = "ababc", word2 = "ba";
		String sequence3 = "ababc", word3 = "ac";
		
		
		int res = maxRepeating(sequence3, word3);
		System.out.println(res);
	}
	/*
	 * For a string sequence, a string word is k-repeating 
	 * if word concatenated k times is a substring of sequence. 
	 * The word's maximum k-repeating value is the highest value k 
	 * where word is k-repeating in sequence. 
	 * If word is not a substring of sequence, word's maximum k-repeating value is 0.	 
	 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
	 */
    public static int maxRepeating(String sequence, String word) {
    	int res = 0;
    	StringBuilder sb = new StringBuilder(word);
    	
    	while (true) {
    		
    		if (sequence.indexOf(sb.toString()) < 0)
    			break;
    		res++;
    		sb.append(word);
    	}
    	
    	return res;
    }
}
