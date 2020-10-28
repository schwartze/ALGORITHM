package algorithm;

public class NegativeMatrix {

	public static void main(String[] args) {
		int[][] grid = {
				{4, 3, 2, -1},
				{3, 2, 1, -1},
				{1, 1, -1, -2},
				{-1, -1, -2, -3}
			};
		int res = countNegatives(grid);
		System.out.println(res);
	}
	
	public static int countNegatives (int[][] grid) {
		int negCount = 0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = grid[i].length - 1; j >= 0; j--) {
				
				if (grid[i][j] >= 0)
					break;
				negCount++;
			}
		}
		return negCount;
	}
}
