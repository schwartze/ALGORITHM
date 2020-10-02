package algorithm;

public class BalancedString {

	public static void main(String[] args) {
		String s = "RLRRRLLRLL";
		BalancedString bString = new BalancedString();
		int res = bString.balancedStringSplit(s);
		System.out.println(res);
	}
	
    public int balancedStringSplit(String s) {
    	int res = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
        	int firstCnt = 1, secondCnt = 0;
    		
    		for (int j = i + 1; j < s.length(); j++) {
    			
    			if (c == s.charAt(j))
    				firstCnt++;
    			else 
    				secondCnt++;

    			if (firstCnt < secondCnt) {
    				i = j;
    				break;
    			}
    			
    			if (firstCnt == secondCnt) {
    				i = j;
    				break;
    			}
    		}
    		res++;
    	}
    	return res;
    }
}
