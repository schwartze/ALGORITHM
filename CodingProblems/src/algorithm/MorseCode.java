package algorithm;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {
	
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		MorseCode mCode = new MorseCode();
		int res = mCode.uniqueMorseRepresentations(words);
		System.out.println(res);
	}
	// given a list of words, each word can be written as a concatenation of the Morse code of each letter. 
	// For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). 
	// We'll call such a concatenation, the transformation of a word.
	// Return the number of different transformations among all words we have.
    public int uniqueMorseRepresentations(String[] words) {
    	String[] alphabetInMorse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    	Set<String> set = new HashSet<>();
    	
    	for (String str : words) {
    		StringBuffer temp = new StringBuffer();
    		
    		for (int i = 0; i < str.length(); i++) {
    			temp.append(alphabetInMorse[str.charAt(i) - 97]);
    		}
    		set.add(temp.toString());
    	}
    	return set.size();
    }
}
