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
		
		int[][] mat3 = {
				{3,9},
				{2,4},
				{1,2},
				{9,8},
				{7,3}
			};
		
		diagonalSort(mat3);
		
		for (int[] nums : mat3) {
			for (int n : nums)
				System.out.print(n + ", ");
			System.out.println();
		}
		
	}

    public static int[][] diagonalSort(int[][] mat) {
    	
    	for (int i = 0; i < mat[0].length - 1; i++)
    		sortHorizontal(mat, i);
    	
    	for (int i = 1; i < mat.length - 1; i++)
    		sortVertical(mat, i);
    	
    	return mat;
    }
    
    private static void sortHorizontal(int[][] mat, int j) {
    	
    	for (int a = 0; a < mat.length - 1; a++) {
    		
    		for (int b = a + 1; b < mat.length && b + j < mat[0].length; b++) {
    			
    			if (mat[a][a + j] > mat[b][b + j]) {
    				int temp = mat[a][a + j];
    				mat[a][a + j] = mat[b][b + j];
    				mat[b][b + j] = temp;
    			}
    		}
    	}
    }
    
    private static void sortVertical(int[][] mat, int j) {
    	
    	for (int a = 0; a + j < mat.length - 1; a++) {
    		
    		for (int b = a + 1; b + j < mat.length && b < mat[0].length; b++) {
    			
    			if (mat[a + j][a] > mat[b + j][b]) {
    				int temp = mat[a + j][a];
    				mat[a + j][a] = mat[b + j][b];
    				mat[b + j][b] = temp;
    			}
    		}
    	}
    } 
}
