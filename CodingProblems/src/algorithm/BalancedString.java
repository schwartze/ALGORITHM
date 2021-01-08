package algorithm;

public class BalancedString {

	public static void main(String[] args) {
		String s = "RLLLLRRRLR";
		BalancedString bString = new BalancedString();
		int res = bString.balancedStringSplit(s);
		System.out.println(res);
	}
    
    public int balancedStringSplit(String s) {
    	int max = 0, rCnt = 0, lCnt = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == 'R')
    			rCnt++;
    		else 
    			lCnt++;

    		if (rCnt == lCnt) {
    			max++;
    			rCnt = 0;
    			lCnt = 0;
    		}
    	}
    	return max;
    }
}
