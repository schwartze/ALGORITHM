package algorithm;

import java.util.HashMap;
import java.util.Map;

public class QuadCompressor {

	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		
		int[][] arr2 = {
				{1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1},
				{0,0,0,0,1,1,1,1},
				{0,1,0,0,1,1,1,1},
				{0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,1,0,0,1},
				{0,0,0,0,1,1,1,1}
			};
		int[] res = solution(arr2);
		
		System.out.println(res[0] + ", " + res[1]);
	}
	
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        Map<int[], int[]> map = new HashMap<>();
        int size = arr.length; 
        
        for (int i = size / 2; i / 2 >= 0; i-=2) {
        	
        	int w = 0, h = 0, len = i == 0 ? 1 : i;
        	
        	for (int j = 0; j < (size * size) / (len * len); j++) {
        		int[] pos = {w, h};
        		
        		if (hasCompressed(map, pos)) {
            		h += len;
            		if (h == size) {
            			h = 0;
            			w += len;
            		}
        			continue;
        		}
        		
        		int[] countArr = compress(arr, pos, len);
        		
        		if (countArr[0] == 0) {
        			map.put(pos, new int[] {len, 1});
        		}
        		
        		if (countArr[1] == 0) {
        			map.put(pos, new int[] {len, 0});
        		}
        		
        		h += len;
        		if (h == size) {
        			h = 0;
        			w += len;
        		}
        	}
        }
        
        for (int[] arrRes : map.values()) {
        	answer[arrRes[1]]++;
        }
        return answer;
    }
    
    private static boolean hasCompressed(Map<int[], int[]> map, int[] pos) {
    	
    	for (int[] compressedArea : map.keySet()) {
    		int compSize = map.get(compressedArea)[0] - 1;
    		
    		if (compressedArea[0] <= pos[0] && pos[0] <= compressedArea[0] + compSize && 
    				compressedArea[1] <= pos[1] && pos[1] <= compressedArea[1] + compSize) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    private static int[] compress(int[][] arr, int[] startPos, int length) {
    	int[] numCount = new int[2];
    	
    	for (int i = startPos[0]; i < startPos[0] + length; i++) {
    		for (int j = startPos[1]; j < startPos[1] + length; j++) {
				numCount[arr[i][j]]++;
    		}
    	}
    	return numCount;
    }
}
