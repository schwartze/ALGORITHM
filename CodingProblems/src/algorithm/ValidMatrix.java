package algorithm;

public class ValidMatrix {
	
	public static void main(String[] args) {
		int[] rowSum = {14, 9};
		int[] colSum = {6, 9, 8};
		
		int[] rowSum2 = {3, 8};
		int[] colSum2 = {4, 7};
		
		int[] rowSum3 = {5, 7, 10};
		int[] colSum3 = {8, 6, 8};
		
		int[] rowSum4 = {1, 0};
		int[] colSum4 = {1};
		
		int[] rowSum5 = {0};
		int[] colSum5 = {0};
		
		
		int[][] matrix = restoreMatrix(rowSum5, colSum5);
		
		for (int[] nums: matrix) {
			for (int n : nums) {
				System.out.print(n + ",");
			}
			System.out.println();
		}
	}
	/*
	 * You are given two arrays rowSum and colSum of non-negative integers 
	 * where rowSum[i] is the sum of the elements in the ith row and 
	 * colSum[j] is the sum of the elements of the jth column of a 2D matrix. 
	 * In other words, you do not know the elements of the matrix, 
	 * but you do know the sums of each row and column.
	 */

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    	int[][] matrix = new int[rowSum.length][colSum.length];
    	int[] arr = new int[Math.max(rowSum.length, colSum.length)];
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (i >= rowSum.length) {
    			arr[i] = colSum[i];
    			continue;
    		}
    		
    		if (i >= colSum.length) {
    			arr[i] = rowSum[i];
    			continue;
    		}
    		matrix[i][i] = Math.min(rowSum[i], colSum[i]);
    		arr[i] = colSum[i] - rowSum[i];
    	}

    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == 0)
    			continue;

    		for (int j = 0; arr[i] > 0 || j < arr.length; j++) {
    			if (arr[i] + arr[j] > arr[i] || i == j || arr[j] == 0)
    				continue;
    			
    			if (arr[i] > 0) 
    				matrix[j][i] = Math.min(Math.abs(arr[i]), Math.abs(arr[j]));
    			else 
    				matrix[i][j] = Math.min(Math.abs(arr[i]), Math.abs(arr[j]));
    			
    			if (Math.abs(arr[i]) > Math.abs(arr[j])) {
    				arr[i] = arr[i] + arr[j];
    				arr[j] = 0;
    			} else {
        			arr[j] = arr[i] + arr[j];
    				arr[i] = 0;
    			}
			}
    	}
    	
    	return matrix;
    }
}
