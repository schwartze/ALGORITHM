package algorithm;

public class Submatrices {
	
	public static void main(String[] args) {
		int [][] matrix =
			{
				  {0,1,1,1},
				  {1,1,1,1},
				  {0,1,1,1}
			};
		int [][] matrix2 =
			{
				  {1,0,1},
				  {1,1,0},
				  {1,1,0}
			};
		
		int res = countSquares(matrix2);
		System.out.println(res);
	}

    public static int countSquares(int[][] matrix) {
    	int squares = 0;
    	
    	for (int i = 0; i < matrix.length; i++) {
    		
    		for (int j = 0; j < matrix[i].length; j++) {
    			if (matrix[i][j] == 0)
    				continue;
    			squares += helper(matrix, i, j);
    		}
    	}
    	return squares;
    }
    
    private static int helper(int[][] matrix, int col, int row) {
    	int result = 1;
    	int min = Math.min(matrix.length - col, matrix[0].length - row);
    	int idx = 1;

    	while (idx < min) {
        	boolean isSquare = true;
    
    		for (int h = 0; h <= idx; h++) {
        		
        		for (int w = 0; w <= idx; w++) {
        			if (idx > 1 && h < idx && w < idx)
        				continue;
        			
        			if (matrix[h + col][w + row] == 0) {
        				isSquare = false;
        				break;
        			}
        		}
        	}
    		if (isSquare)
    			result++;
    		idx++;
    	}
    	return result;
    }
}
