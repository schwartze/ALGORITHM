package algorithm;

public class AdjacentDuplicates {

	public static void main(String[] args) {
		String S = "abbaca";
		AdjacentDuplicates aDup = new AdjacentDuplicates();
		String res = aDup.removeDuplicates(S);
		System.out.println(res);
	}
	
    public String removeDuplicates(String S) {
    	StringBuilder sb = new StringBuilder(S);
    	boolean hasDuplicates = true;
    	
    	while (hasDuplicates) {
    		hasDuplicates = false;
    		
    		for (int i = 0; i < sb.length() - 1; i++) {
    		
    			if (sb.charAt(i) == sb.charAt(i + 1)) {
    				sb.delete(i, i + 2);
    				hasDuplicates = true;
    				break;
    			}
    		}
    	}
    	return sb.toString();
    }
}
