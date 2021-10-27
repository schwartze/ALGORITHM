package algorithm;

public class MatrixScore {
	
	public static void main(String[] args) {
		int[][] A = {
				{0,0,1,1},
				{1,0,1,0},
				{1,1,0,0}
		};
		
		MatrixScore mScore = new MatrixScore();
		int max = mScore.matrixScore(A);
		System.out.println(max);
	}

    public int matrixScore(int[][] A) {
    	int max = 0;
    	int[] colCount = new int[A[0].length];
    	
    	for (int i = 0; i < A.length; i++) {
    		
    		if (A[i][0] == 0) 
    			flipRow(A[i]);
    		
    		for (int j = 0; j < A[i].length; j++) {
    			if (A[i][j] == 1) 
    				colCount[j]++;
    		}
    	}
    	
    	for (int i = 0; i < colCount.length; i++) {
    		if (colCount[i] <= A.length / 2) 
    			flipColumn(A, i);
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		int sum = 0;
    		for (int j = A[i].length - 1; j >= 0; j--) {
    			
    			if (A[i][j] == 1) {
    				sum += Math.pow(2, A[i].length - 1 - j);
    			}
    		}
			max += sum;
    	}
    	
    	return max;
    }
    
    private void flipRow(int[] A) {
    	
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] == 0)
    			A[i] = 1;
    		else
    			A[i] = 0;
    	}
    }
    
    private void flipColumn(int[][] A, int col) {
    	
    	for (int i = 0; i < A.length; i++) {
    		if (A[0][col] == 1)
    			A[0][col] = 0;
    		else
    			A[0][col] = 1;
    	}
    }
}
