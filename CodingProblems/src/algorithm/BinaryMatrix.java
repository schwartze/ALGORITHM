package algorithm;

public class BinaryMatrix {

	public static void main(String[] args) {
		int[][] mat = {
				{0, 0, 0, 1},
				{1, 0, 0, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
		};
		
		int[][] mat1 = {
				{0, 0, 0, 0, 0},
				{1, 0, 0, 0, 0},
				{0, 1, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}
		};
		
		int[][] mat2 = {
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1},
		};
		
		int[][] mat3 = {
				{1, 0, 0},
				{0, 0, 1},
				{1, 0, 0},
		};
		
		BinaryMatrix bMatrix = new BinaryMatrix();
		int res = bMatrix.numSpecial(mat3);
		System.out.println(res);
	}
	// Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, 
	// return the number of special positions in mat.
	// A position (i,j) is called special if mat[i][j] == 1 and 
	// all other elements in row i and column j are 0 
	// (rows and columns are 0-indexed).
	public int numSpecial(int[][] mat) {
		int res = 0;
		
		for (int i = 0; i < mat.length; i++) {
			boolean rowSpecial = false;
			boolean colSpecial = false;
			
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					rowSpecial = isRowSpecial(mat[i], j);
					
					if (rowSpecial)
						colSpecial = isColumnSpecial(mat, i, j);
				}
			}
			if (rowSpecial && colSpecial)
				res++;
		}
    	return res;
    }
	
	private boolean isColumnSpecial(int[][] matrix, int i, int j) {
		boolean isSpecial = true;
		
		for (int col = 0; col < matrix.length; col++) {
			if (col == i)
				continue;
			
			if (matrix[col][j] == 1) {
				isSpecial = false;
				break;
			}
		}
		return isSpecial;
	}
	
	private boolean isRowSpecial(int[] row, int j) {
		boolean isSpecial = true;
		
		for (int idx = 0; idx < row.length; idx++) {
			if (idx == j)
				continue;
			
			if (row[idx] == 1) {
				isSpecial = false;
				break;
			}
		}
		return isSpecial;
	}
}
