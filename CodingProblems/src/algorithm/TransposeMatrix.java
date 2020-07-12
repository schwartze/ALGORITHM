package algorithm;

public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] A = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		
		int[][] B = {
				{1,2,3},
				{4,5,6}
				};
		
		TransposeMatrix tMatrix = new TransposeMatrix();
		int[][] res = tMatrix.transpose(B);
		
		for (int[] arr : res) {
			
			for (int n : arr)
				System.out.print(n + " ");
			System.out.println();
		}
	}
	
    public int[][] transpose(int[][] A) {
    	int[][] res = new int[A[0].length][A.length];
    	
    	for (int i = 0; i < A.length; i++) {
    		
    		for (int j = 0; j < A[i].length; j++) {
    			res[j][i] = A[i][j];
    		}
    	}
    	
    	return res;
    }
}
