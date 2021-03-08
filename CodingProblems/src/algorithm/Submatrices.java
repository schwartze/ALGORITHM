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
		
		int [][] matrix3 =
			{
				  {0, 1, 1, 1},
				  {1, 1, 0, 1},
				  {1, 1, 1, 1},
				  {1, 0, 1, 0}
			};
		
		int res = countSquares(matrix3);
		System.out.println(res);
	}

    public static int countSquares(int[][] matrix) {
    	int squares = 0;
    	
    	for (int i = 0; i < matrix.length; i++) {
    		
    		for (int j = 0; j < matrix[i].length; j++) {
    			if (matrix[i][j] == 0)
    				continue;
    			squares += helper(matrix, i, j, Math.min(matrix.length - i, matrix[i].length - j));
    		}
    	}
    	return squares;
    }
    
    private static int helper(int[][] matrix, int i, int j, int min) {
    	int result = 1;
    	int idx = 0;
    	
    	while (++idx < min) {
    		boolean isSquare = true;
    		
    		for (int col = 0; col <= idx; col++) {
    			
    			for (int row = 0; row <= idx; row++) {
    				if (col < idx && row < idx)
    					continue;
    				
    				if (matrix[col + i][row + j] != 1) {
    					isSquare = false;
    					break;
    				}
    			}
    		}
    		if (!isSquare)
    			break;
			result++;
    	}
    	return result;
    }
}
