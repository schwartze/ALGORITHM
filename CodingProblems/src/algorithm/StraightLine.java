package algorithm;

public class StraightLine {
    
	public static void main(String[] args) {
		int[][] coordinates = {
				{1,2},
				{2,3},
				{3,4},
				{4,5},
				{5,6},
				{6,7}
		};
		
		int[][] coordinates2 = {
				{1,1},
				{2,2},
				{3,4},
				{4,5},
				{5,6},
				{7,7}
		};
		
		int[][] coordinates3 = {
				{1,1},
				{2,2},
				{2,0}
		};
		
		int[][] coordinates4 = {
				{0,0},
				{0,1},
				{0,-1}
		};
		
		StraightLine sLine = new StraightLine();
		boolean res = sLine.checkStraightLine(coordinates4);
		System.out.println(res);
	}
	
	public boolean checkStraightLine(int[][] coordinates) {
		boolean res = true;
		int[] initPoint = coordinates[0];
		
		for (int i = 1; i < coordinates.length - 1; i++) {
			int[] pointOne = coordinates[i];
			int[] pointTwo = coordinates[i + 1];
			
			if ((pointTwo[0] - pointOne[0]) * (pointOne[1] - initPoint[1]) != 
					(pointOne[0] - initPoint[0]) * (pointTwo[1] - pointOne[1])) {
				res = false;
				break;
			}
			initPoint = pointOne;
		}
		return res;
    }

}
