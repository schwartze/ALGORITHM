package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistance {

	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';

		ShortestDistance sDistance = new ShortestDistance();
		int[] res = sDistance.shortestToChar(S, C);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public int[] shortestToChar(String S, char C) {
     
    	List<Integer> cPos = new ArrayList<>();
    	int[] res = new int[S.length()];
    	
    	for (int i = 0; i < S.length(); i++) {
    		if (S.charAt(i) == C)
    			cPos.add(i);
    	}
    	int j = 0;
		
    	for (int i = 0; i < S.length(); i++) {
    		
    		if (j < cPos.size() - 1 && Math.abs(cPos.get(j) - i) > Math.abs(cPos.get(j + 1) - i))
    			j++;

    		int cur = Math.abs(cPos.get(j) - i);
    		int nex = Integer.MAX_VALUE;
    		
    		if (j < cPos.size() - 1)
    			nex = Math.abs(cPos.get(j + 1) - i);
    		
    		res[i] = Math.min(cur, nex);
    	}
    	
    	return res;
    }
}
