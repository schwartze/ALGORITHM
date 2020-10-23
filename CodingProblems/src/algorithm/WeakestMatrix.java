package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WeakestMatrix {
	
	public static void main(String[] args) {
		int[][] mat = {
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 0},
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 1}
		};
		
		int[][] mat2 = {
				{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}
		;
		int k2 = 1;
		int k = 3;
		int[] res = kWeakestRows(mat2, k2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// return the index of matrix row
	// which contains lowest 1 values
    public static int[] kWeakestRows(int[][] mat, int k) {  	
    	int[] res = new int[k];
    	Map<Integer, List<Integer>> map = new TreeMap<>();
    	
    	for (int i = 0; i < mat.length; i++) {
    		List<Integer> idxList;
    		int soldierCount = 0;
    		
    		for (int j = 0; j < mat[i].length; j++) {
    			if (mat[i][j] > 0)
    				soldierCount++;
    		}
    		if (map.containsKey(soldierCount)) {
    			idxList = map.get(soldierCount);
    			idxList.add(i);
    			map.put(soldierCount, idxList);
    			continue;
    		}
    		idxList = new ArrayList<>();
    		idxList.add(i);
    		map.put(soldierCount, idxList);
    	}
    	
    	int idx = 0;
    	for (List<Integer> list : map.values()) {
    		
    		for (int i = 0; i < list.size(); i++) {
    			res[idx] = list.get(i);
    			idx++;
    			
    			if (idx >= k)
    				break;
    		}
			if (idx >= k)
				break;
    	}
    	return res;
    }
}
