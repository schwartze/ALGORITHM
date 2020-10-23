package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
		int[] res = kWeakestRows2(mat, k);
		
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
    
    
    public static int[] kWeakestRows2(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }
        
        while (k > 0)
            ans[--k] = pq.poll()[1];
        
        return ans;
    }
    
    private static int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    
    class MyComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b) {
            int result = 0;
            if(a[0] != b[0]){
                result =  b[0] - a[0];
            }else{
                result = b[1] - a[1];
            }
            return result;
        }
    }
}
