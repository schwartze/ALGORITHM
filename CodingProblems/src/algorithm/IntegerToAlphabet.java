package algorithm;

public class IntegerToAlphabet {

	public static void main(String[] args) {
		String s = "1326#";
		String res = freqAlphabets(s);
		System.out.println(res);
	}
	
	// a ~ i : 1 ~ 9
	// j ~ z : 10# ~ 26#
    public static String freqAlphabets(String s) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < s.length(); i++) {
    		int num = 0;
    		if (s.charAt(i + 2) == '#' && i + 2 < s.length()) {
    			num = Integer.parseInt(s.substring(i, i + 2));
    			i = i + 2;
    		}
    		else 
    			num = Integer.parseInt(s.charAt(i) + "");
    		
    		sb.append((char)(num + 96));
    	}
    	
    	return sb.toString();
    }
}
