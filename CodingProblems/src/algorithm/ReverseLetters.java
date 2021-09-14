package algorithm;

public class ReverseLetters {

    public String reverseOnlyLetters(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	
    	for (int i = 0, j = s.length() - 1; i < sb.length(); i++, j--) {
    		char resLowercased = sb.charAt(i);
    		char tarLowercased = s.charAt(j);
    		
    		if (resLowercased < 97 || tarLowercased < 97)
    			continue;
    		
    		sb.setCharAt(i, s.charAt(j));
    	}
    	return sb.toString();
    }
}
