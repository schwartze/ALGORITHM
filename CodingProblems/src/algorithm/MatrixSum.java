package algorithm;

public class MatrixSum {
	
	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int k = 1;
		
		int[][] res = matrixBlockSum(mat, k);
		
		for (int i = 0; i < res.length; i++) {
			
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + ", ");
			}
			System.out.println();
		}
		
	}
	/*
	 	Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

		i - k <= r <= i + k,
		j - k <= c <= j + k, and
		(r, c) is a valid position in the matrix.
	 */
	
    public static int[][] matrixBlockSum(int[][] mat, int k) {
    	int[][] resMat = new int[mat.length][mat[0].length];
    	
    	for (int i = 0; i < mat.length; i++) {
    		
    		for (int j = 0; j < mat[i].length; j++) {
    			int sum = getRangeSum(mat, i, j, k);
    			resMat[i][j] = sum;
    		}
    	}
    	
    	return resMat;
    }
    
    private static int getRangeSum(int[][] mat, int col, int row, int k) {
    	int sum = 0;
    	
    	for (int i = col - k; i <= col + k && i < mat.length; i++) {
    		if (i < 0)
    			continue;
    		
    		for (int j = row - k; j <= row + k && j < mat[i].length; j++) {
    			if (j < 0)
    				continue;
    			sum += mat[i][j];
    		}
    	}
    	
    	return sum;
    }

}
