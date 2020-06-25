package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LargeGroup {

	public static void main(String[] args) {
		String S = "aa";
		LargeGroup lGroup = new LargeGroup();
		List<List<Integer>> res = lGroup.largeGroupPositions(S);
		
		
		for (List<Integer> pos : res) {
			for (int n : pos)
				System.out.print(n + ", ");
			System.out.println();
		}
	}
	
	// a group is large only when it has 3 or more characters 
	// return the list of starting and ending positions of every large group of the given String
    public List<List<Integer>> largeGroupPositions(String S) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	for (int i = 0; i < S.length() - 1; i++) {
    		List<Integer> pos = new ArrayList<>(2);
    		pos.add(i);
    		
    		int j = i + 1;
    		while (j < S.length() && S.charAt(i) == S.charAt(j)) {
    			j++;
    		}
    		pos.add(j - 1);
    		
    		if (pos.get(1) - pos.get(0) > 1) {
    			res.add(pos);
    			i = j - 1;
    		}
    	}
    	return res;
    }
}
