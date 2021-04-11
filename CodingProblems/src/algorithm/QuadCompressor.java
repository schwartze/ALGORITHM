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
		int[] res = solution(arr);
		
		System.out.println(res[0] + ", " + res[1]);
	}
	
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        compress(arr, new int[] {0, 0}, arr.length, answer);
        
        return answer;
    }
    
    private static void compress(int[][] arr, int[] pos, int length, int[] ans) {
    	int zeroCount = 0, oneCount = 0;
    	boolean compressible = true;
    	
    	for (int i = pos[0]; i < pos[0] + length; i++) {
    		for (int j = pos[1]; j < pos[1] + length; j++) {
    			if (arr[i][j] == 0)
    				zeroCount++;
    			else 
    				oneCount++;
    			
    			if (zeroCount > 0 && oneCount > 0) {
    				compressible = false;
					break;
    			}
    		}
    		if (!compressible)
    			break;
    	}
    	
    	if (zeroCount == 0) {
    		ans[1]++;
    		return;
    	}

    	if (oneCount == 0) {
    		ans[0]++;
    		return;
    	}
    	
    	length /= 2;
		for (int i = pos[0]; i < arr.length; i+=length) {
			
			for (int j = pos[1]; j < arr[i].length; j+=length) {
				compress(arr, new int[] {i, j}, length, ans);
			}
    	}
    }
}
