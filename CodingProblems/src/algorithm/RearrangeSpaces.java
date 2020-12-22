package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpaces {

	public static void main(String[] args) {
		String text = "a";
		String text2 = "   hello";
		
		String res = reorderSpaces(text2);
		System.out.println(res);
	}
	// Rearrange the spaces so that there is an equal number of spaces 
	// between every pair of adjacent words and that number is maximized. 
	// If you cannot redistribute all the spaces equally, 
	// place the extra spaces at the end, meaning the returned string 
	// should be the same length as text.
    public static String reorderSpaces(String text) {
    	List<String> words = new ArrayList<>();
    	int spaceCount = 0;
    	StringBuilder sb = new StringBuilder();
    	StringBuilder res = new StringBuilder();
    	
    	for (int i = 0; i < text.length(); i++) {
    		
    		if (text.charAt(i) == 32) {
    			spaceCount++;
    			
    	    	if (sb.length() > 0) {
        			words.add(sb.toString());
        			sb.delete(0, sb.length());
    	    	}
    			continue;
    		}
    		sb.append(text.charAt(i));
    	}
    	if (sb.length() > 0)
    		words.add(sb.toString());
    	
    	int perSpace = (words.size() - 1) == 0 ? spaceCount : spaceCount / (words.size() - 1);
    	
    	for (String word : words) {
    		res.append(word);
    		
    		int i = perSpace;
    		while (spaceCount > 0 && i-- > 0) {
    			res.append(" ");
    			spaceCount--;
    		}
    	}
    	
    	while (spaceCount-- > 0)
    		res.append(" ");
    	
    	return res.toString();
    }
}
