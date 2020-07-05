package algorithm;

public class MagicSquare {

	public static void main(String[] args) {
		int[][] grid = {
				{4, 3, 8, 4},
				{9, 5, 1, 9},
				{2, 7, 6, 2}
		};

		int[][] grid2 = {
				{8, 1, 6},
				{3, 5, 7},
				{4, 9, 2}
		};

		int[][] grid3 = {
				{1, 1, 1},
				{4, 5, 6},
				{9, 9, 9}
		};

		
		MagicSquare mSquare = new MagicSquare();
		int ans = mSquare.numMagicSquaresInside(grid2);
		System.out.println(ans);
	}
	
    public int numMagicSquaresInside(int[][] grid) {
     
    	int[] leftToRight = new int[3];
    	int[] rightToLeft = new int[3];
    	int res = 0;
    	
    	if (grid.length < 3 && grid[0].length < 3)
    		return 0;

    	for (int i = 0, l = 0; i < grid.length; i+=3, l++) {
    		int x = 0, y = l, z = 0, a = l + 2;
    		int xySum = 0;
    		int zaSum = 0;
    		
    		for (int j = 0; j < 3; j++) {
    			leftToRight[j] = grid[x][y];
    			rightToLeft[j] = grid[z][a];
    			x++; 
    			y++;
    			z++;
    			a--;
    		}

    		for (int k = 0; k < leftToRight.length; k++) {
    			xySum += leftToRight[k];
    			zaSum += rightToLeft[k];
    		}
    		if (xySum == zaSum)
    			res++;
    	}
    	
    	return res;
    }
}
