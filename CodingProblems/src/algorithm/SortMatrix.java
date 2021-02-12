package algorithm;

import java.util.Arrays;

import javax.swing.Box.Filler;

public class SortMatrix {

	public static void main(String[] args) {
		int[][] mat = {
				{3, 3, 1, 1},
				{2, 2, 1, 2},
				{1, 1, 1, 2}
		};

		int[][] mat2 = {
				{11,25,66,1,69,7},
				{23,55,17,45,15,52},
				{75,31,36,44,58,8},
				{22,27,33,25,68,4},
				{84,28,14,11,5,50}
		};
		
		diagonalSort(mat);
		
		for (int[] nums : mat) {
			for (int n : nums)
				System.out.print(n + ", ");
			System.out.println();
		}
		
	}
	
    public static int[][] diagonalSort(int[][] mat) {

    	for (int i = 0; i < mat[0].length - 1; i++) {
    		sortDiagonally(mat, 0, i, true);
    	}

       	for (int i = 1; i < mat.length - 1; i++) {
    		sortDiagonally(mat, i, 0, false);
    	}

    	return mat;
    }
	
    private static void sortDiagonally(int[][] mat, int i, int j, boolean isHorizontal) {
    	int limit = isHorizontal ? mat[0].length - 1 : mat.length - 1;
    	
    	for (int y = 0; y < mat[0].length - 1; y++) {
    		
    		for (int x = y + 1; j + x < limit; x++) {

    			if (mat[i + y][j + y] > mat[i + x][j + x]) {
    				int temp = mat[i + y][j + y];
    				mat[i + y][j + y] = mat[i + x][j + x];
    				mat[i + x][j + x] = temp;
    			}
    		}
    	}
    }
}
