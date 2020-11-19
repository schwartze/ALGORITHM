package algorithm;

public class ConsecutiveCharacters {

	public static void main(String[] args) {
		String s = "leetcode";
		int res = maxPower(s);
		System.out.println(res);
	}
	
    public static int maxPower(String s) {
    	int res = 1;
    	int count = 1;
    	char prev = s.charAt(0);
    	
    	for (int i = 1; i < s.length(); i++) {
    		if (prev != s.charAt(i)) {
    			res = Math.max(res, count);
    			prev = s.charAt(i);
    			count = 0;
    		}
    		count++;
    		prev = s.charAt(i);
    		
    		if (i == s.length() - 1)
    			res = Math.max(res, count);	
    	}
    	return res;
    }
}
