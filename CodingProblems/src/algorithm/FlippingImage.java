package algorithm;

public class FlippingImage {
    
	public static void main(String[] args) {
		int[][] A = {
				{1, 1, 0},
				{1, 0, 1},
				{0, 0, 0}
		};
		
		int[][] B = {
				{1, 1, 0, 0},
				{1, 0, 0, 1},
				{0, 1, 1, 1},
				{1, 0, 1, 0}
		};

		int[][] C = {
				{1}
		};

		FlippingImage imageFlipper = new FlippingImage();
		int[][] res = imageFlipper.flipAndInvertImage(C);
		
		for (int[] arr : res) {
			for (int n : arr)
				System.out.print(n + ", ");
			System.out.println();
		}
	}
	
	
	public int[][] flipAndInvertImage(int[][] A) {
		int[][] res = new int[A.length][A[0].length];
		
		for (int i = 0; i < A.length; i++) {
			
			int[] temp = new int[A[i].length];
			for (int j = A[i].length - 1, k = 0; j >= 0; j--, k++) {
				temp[k] = A[i][j]; 
			}
			res[i] = temp;
		}
		
		for (int i = 0; i < res.length; i++) {
			
			for (int j = 0; j < res[i].length; j++) {
				
				if (res[i][j] == 0)
					res[i][j] = 1;
				else 
					res[i][j] = 0;
			}
		}
		return res;
    }

}
