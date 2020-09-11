package algorithm;

public class StringDivisor {

	public static void main(String[] args) {
		String str1 = "ABCDEF";
		String str2 = "ABC";
		
		StringDivisor sDivisor = new StringDivisor();
		String res = sDivisor.gcdOfStrings(str1, str2);
		System.out.println(res);
	}
	
    public String gcdOfStrings(String str1, String str2) {
    	String res = "";

    	if (str1.indexOf(str2) < 0 && str2.indexOf(str1) < 0)
    		return res;

    	StringBuilder sb = new StringBuilder();
    	sb.append(str1.substring(0, str1.indexOf(str1.charAt(0), 1)));
    	
    	if (str2.indexOf(sb.toString()) < 0)
    		return res;
    	
    	if (hasOtherLetter(str1, sb.toString()) || hasOtherLetter(str2, sb.toString()))
    		return res;
    	
    	return sb.toString();
    }
    
    private boolean hasOtherLetter(String fullStr, String str) {
    	boolean hasLetter = false;
    	int i = str.length(); 
    	
    	while (i < fullStr.length()) {
    		
    		int idx = fullStr.indexOf(str, i);
    		i += str.length();
    		if (idx < 0) {
    			hasLetter = true;
    			break;
    		}
    	}
    	return hasLetter;
    }
}
