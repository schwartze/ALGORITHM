package algorithm;

public class MinimumFalling {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{2, 1, 3},
				{6, 5, 4},
				{7, 8, 9}
		};
		
		int[][] matrix2 = {
				{-19, 57},
				{-40, -5}
		};
		
		
		int res = minFallingPathSum(matrix2);
		System.out.println(res);
	}
	
    public static int minFallingPathSum(int[][] matrix) {
        int sum = 101, idx = 0;
        
        for (int i = 0; i < matrix[0].length; i++) {
        	if (sum > matrix[0][i]) {
            	sum = matrix[0][i];
            	idx = i;
        	}
        }
        
        for (int i = 1; i < matrix.length; i++) {
        	int min = 101, minIdx = idx;
        	
        	for (int j = minIdx - 1; j <= minIdx + 1; j++) {
        		if (j < 0 || j > matrix.length - 1) 
        			continue;
        		
        		if (min > matrix[i][j]) {
        			min = matrix[i][j];
        			idx = j;
        		}
        	}
        	sum += min;
        }
        
    	return sum;
    }
}
