package algorithm;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 1, 2, 3},
				{9, 5, 1, 2}
		};
		
		int[][] matrix2 = {
				{1, 2},
				{2, 2}
		};
		
		ToeplitzMatrix tMatrix = new ToeplitzMatrix();
		boolean res = tMatrix.isToeplitzMatrix(matrix2);
		System.out.println(res);
	}
	
	// A matrix is Toeplitz if every diagonal from top-left to bottom-right
	// has the same element
	public boolean isToeplitzMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length - 1; i++) {
			
			int temp = i;
			for (int j = 0; j < matrix[i].length - 1; j++) {
				
				if (matrix[i][j] != matrix[temp + 1][j+ 1])
					return false;
			}
		}
    	return true;
    }

}
