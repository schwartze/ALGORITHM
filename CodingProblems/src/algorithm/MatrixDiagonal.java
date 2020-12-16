package algorithm;

public class MatrixDiagonal {

	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int[][] mat1 = {
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1}
		};
		
		int[][] mat2 = {
				{5}
		};
		
		int[][] mat3 = {
				{7, 3, 1, 9},
				{3, 4, 6, 9},
				{6, 9, 6, 6},
				{9, 5, 8, 5}
		};
		
		int res = diagonalSum(mat);
		System.out.println(res);
	}
	
    public static int diagonalSum(int[][] mat) {
    	int res = 0;
    	
    	for (int i = 0, j = 0, k = 0, l = mat.length - 1; i < mat.length; i++, j++, k++, l--) {
    		res += mat[j][i];
    		
    		if (i == k && j == l) 
    			continue;
    		res += mat[l][k];
    	}
    	return res;
    }
}
