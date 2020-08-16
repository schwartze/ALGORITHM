package algorithm;

public class DIStringMatch {

	public static void main(String[] args) {
		String S = "DDI";
		DIStringMatch sMatch = new DIStringMatch();
		int[] res = sMatch.diStringMatch(S);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// I: increase
	// D: decrease
    public int[] diStringMatch(String S) {
     
    	int[] res = new int[S.length() + 1];
    	
    	for (int idx = 0, i = 0, d = S.length(); idx < S.length(); idx++) {
    		
    		if (S.charAt(idx) == 'I') {
    			res[idx] = i;
    			i++;
    		} else {
    			res[idx] = d;
    			d--;
    		}
    	}
    	
    	res[S.length()] = S.charAt(S.length() - 1) == 'I' ? 
    					  res[S.length() - 1] + 1 : 
    					  res[S.length() - 1] - 1;
    	
    	return res;
    }
}
