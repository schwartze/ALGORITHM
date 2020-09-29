package algorithm;

public class Square {

	public static void main(String[] args) {
		int[][] matrix = {
							{0,1,1,1},
							{1,1,1,1},
							{1,1,1,1},
							{0,0,1,0}
						};
		
		int res = getAreaOfSqurae(matrix);
		System.out.println(res);
	}

	public static int getAreaOfSqurae(int[][] matrix) {
		int res = 0;
		
		for (int i = 0; i < matrix.length; i++ ) {
			
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == 1 && 
						matrix.length - i > res &&
						matrix[i].length - j > res) {
					res = Math.max(res, helper(i, j, matrix));
				}
			}
		}
		return res * res;
	}
	
	private static int helper(int x, int y, int[][] matrix) {
		int maxWidth = 0;
		int width = Math.min(matrix.length - x, matrix[x].length - y);
		
		while (width > x) {
			boolean containsZero = false;

			for (int i = x + width - 1; i >= x; i--) {
				
				for (int j = y + width - 1; j >= y; j--) {

					if (matrix[i][j] == 0) {
						containsZero = true;
						break;
					}
				}
				if (containsZero)
					break;
			}
			if (!containsZero)
				maxWidth = Math.max(maxWidth, width);
			width--;
		}
		return maxWidth;
	}
}
