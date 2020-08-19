package algorithm;

import java.util.Arrays;

public class SortedArray {

	public static void main(String[] args) {
		int[] arr = {0, -4, -6, 4, 2, 10};
		SortedArray sArray = new SortedArray();
		int[] res = sArray.sortedSquares(arr);
		
		for (int n : res)
			System.out.print(n + ", "); 
	}
	
    public int[] sortedSquares(int[] A) {
     
    	for (int i = 0; i < A.length; i++) 
    		A[i] = A[i] * A[i];
    	Arrays.sort(A);
    	
    	return A;
    }
}
