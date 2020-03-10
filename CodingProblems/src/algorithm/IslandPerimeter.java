package algorithm;

public class IslandPerimeter {
	/*
	 * 
	[[0,1,0,0],
	 [1,1,1,0],
	 [0,1,0,0],
	 [1,1,0,0]]
	 : find the perimeter of island when 1 represent square
	 *
	 */
	
	public static void main(String[] args) {
		IslandPerimeter is = new IslandPerimeter();
		
		int[][] grid = 
				{{0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		
		int result = is.getIslansPerimeter(grid);
		
		System.out.println(result);
	}
	
	public int getIslansPerimeter(int[][] grid) {
		int result = 0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[i].length; j++) {
				
				if (grid[i][j] == 1) {
					result += 4;

					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						result -= 2;
					
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
						result -= 2;
				}
			}
		}
		return result;
	}
	
}
