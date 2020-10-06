package algorithm;

public class OddCellMatrix {

	public static void main(String[] args) {
		int n = 2, m = 3;
		int[][] indices = {
				{0, 1},
				{1, 1}
		};
		
		OddCellMatrix oMatrix = new OddCellMatrix();
		int res = oMatrix.getOddCellCount(n, m, indices);
		System.out.println(res);
	}
	/*
	 * Given n and m which are the dimensions of a matrix initialized by zeros and 
	 * given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] 
	 * you have to increment all cells in row ri and column ci by 1.
	 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
	 */
    public int oddCells(int n, int m, int[][] indices) {
    	int[][] matrix = new int[n][m];
    	int oddCount = 0;
    	
    	for (int i = 0; i < indices.length; i++) {
    		int x = indices[i][0];
    		int y = indices[i][1];
    		
    		for (int j = 0; j < matrix[x].length; j++) 
    			matrix[x][j]++;
    		
    		for (int k = 0; k < matrix.length; k++) 
    			matrix[k][y]++;
    	}
    	
    	for (int i = 0; i < matrix.length; i++) {
    		
    		for (int j = 0; j < matrix[i].length; j++) {
    			if (matrix[i][j] % 2 == 0)
    				continue;
    			oddCount++;
    		}
    	}
    	return oddCount;
    }
    
    
    public int getOddCellCount(int n, int m, int[][] indices) {
    	boolean[] rows = new boolean[n];
    	boolean[] cols = new boolean[m];
    	int rowCnt = 0, colCnt = 0;
    	
    	for (int i = 0; i < indices.length; i++) {
    		
    		rows[indices[i][0]] ^= true;
    		cols[indices[i][1]] ^= true;
    	}
    	
    	for (boolean isEven : rows) 
    		rowCnt += isEven ? 1 : 0;
    	
    	for (boolean isEven : cols) 
    		colCnt += isEven ? 1 : 0;
    	
    	return (n - rowCnt) * colCnt + (m - colCnt) * rowCnt;
    }
}
