package algorithm;

public class DominationLand {

	public int getMaxLand(int[][] land) {
    	int res = 0, prevMaxIdx = 0;
    	
    	for (int i = 0; i < land.length; i++) {
    		int max = 0, prevIdx = prevMaxIdx, j = 0;
    		
    		for (j = 0; j < land[i].length; j++) {
    			
    			if (land[i][j] > max) {
    				max = land[i][j];
    				prevMaxIdx = j;
    			}
    		}
    		
    		if (prevIdx == j) 
    			res = getMax(land, prevIdx, j, res);
    		
    		res += max;
    	}
    	return res;
    }
    
    private int getMax(int[][] land, int i, int j, int max) {
    	int iMax = 0, iSecondMax = 0, jMax = 0, jSecondMax = 0;
    	
    	for (int a = 0; a < land[i].length; a++) {
    		if (land[i][a] > iMax) {
    			iMax = land[i][a];
    		} else if (land[i][a] > iSecondMax) {
    			iSecondMax = land[i][a];
    		}
    	}
    	
    	for (int a = 0; a < land[j].length; a++) {
    		if (land[j][a] > iMax) {
    			iMax = land[j][a];
    		} else if (land[i][a] > iSecondMax) {
    			iSecondMax = land[j][a];
    		}
    	}
    		
    	if (iMax + jSecondMax > jMax + iSecondMax) {
    		max += jSecondMax;
    	} else {
    		max -= iMax;
    		max += iSecondMax += jMax;
    	}
    	return max;
    }
}
