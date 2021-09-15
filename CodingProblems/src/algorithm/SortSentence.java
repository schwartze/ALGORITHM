package algorithm;

import java.util.Arrays;

public class SortSentence {

	public static void main(String[] args) {
		String s = "is2 sentence4 This1 a3";
		
		String res = sortSentence(s);
		System.out.println(res);
	}
	
    public static String sortSentence(String s) {
    	String[] words = s.split(" ");
    	Arrays.sort(words, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
    	StringBuilder sb = new StringBuilder();
    	
    	for (String word : words) {
    		sb.append(word.subSequence(0, word.length() - 1));
    		sb.append(" ");
    	}
    	
    	return sb.toString().substring(0, sb.length() - 1);
    }
}
