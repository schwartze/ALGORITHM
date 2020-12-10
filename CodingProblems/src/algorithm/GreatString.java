package algorithm;

public class GreatString {

	public static void main(String[] args) {
		String s = "s";
		String res = makeGood(s);
		System.out.println(res);
	}
	// To make the string good, you can choose two adjacent characters 
	// that make the string bad and remove them. 
	// You can keep doing this until the string becomes good.
    public static String makeGood(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	boolean containsBad = true;
    	
    	while (sb.length() > 1 && containsBad) {
    		containsBad = false;
    		
    		for (int i = 0; i < sb.length() - 1; i++) {
    			
    			if (sb.charAt(i) == sb.charAt(i + 1) + 32) {
    				sb.delete(i, i + 2);
    				containsBad = true;
    				continue;
    			}
    			
    			if (sb.charAt(i) + 32 == sb.charAt(i + 1)) {
    				sb.delete(i, i + 2);
    				containsBad = true;
    				continue;
    			}
    		}
    	}
    	
    	return sb.toString();
    }
}
