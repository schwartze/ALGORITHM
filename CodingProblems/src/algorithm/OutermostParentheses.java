package algorithm;

public class OutermostParentheses {

	public static void main(String[] args) {
		String S = "(()())(())";
		OutermostParentheses oParentheses = new OutermostParentheses();
		String res = oParentheses.removeOuterParentheses(S);
		System.out.println(res);
	}
	
	// Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
    public String removeOuterParentheses(String S) {
    	char opening = '(';
    	int open = 0;
    	StringBuffer sb = new StringBuffer();
    	
    	for (int i = 0, j = 0; i < S.length(); i++) {
    		
    		if (S.charAt(i) == opening)
    			open++;
    		else 
    			open--;
    		
    		if (open == 0) {
    			sb.append(S.substring(j + 1, i));
    			j = i + 1;
    		}
    	}
    	
    	return sb.toString();
    }
}
