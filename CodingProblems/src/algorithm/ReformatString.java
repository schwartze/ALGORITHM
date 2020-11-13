package algorithm;

public class ReformatString {

	public static void main(String[] args) {
		String s = "ab123";
		String res = reformat(s);
		System.out.println(res);
	}
	
    public static String reformat(String s) {
    	if (s.length() < 2)
    		return s;
    	
    	StringBuilder letters = new StringBuilder();
    	StringBuilder digits = new StringBuilder();
    	
    	for (int i = 0; i < s.length(); i++) {
    		
    		if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
    			letters.append(s.charAt(i));
    			continue;
    		}
			digits.append(s.charAt(i));
    	}
    	
    	if (letters.length() == 0|| digits.length() == 0)
    		return "";

    	return letters.length() > digits.length() ? 
    			helper(letters.toString(), digits.toString()) : 
				helper(digits.toString(), letters.toString());
    }
    
    private static String helper(String longer, String shorter) {
    	StringBuilder res = new StringBuilder();
    	
    	for (int i = 0, j = 0, k = 0; i < longer.length() + shorter.length(); i++) {
    		
    		if (i % 2 == 0) {
    			res.append(longer.charAt(j));
    			j++;
    		} else {
    			res.append(shorter.charAt(k));
    			k++;
    		}
    	}
    	return res.toString();
    }
}
