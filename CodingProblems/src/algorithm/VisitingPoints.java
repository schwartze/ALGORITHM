package algorithm;

public class VisitingPoints {

	public static void main(String[] args) {
		int[][] points = {
				{1, 1},
				{3, 4},
				{-1, 0}
			};
		
		int[][] points2 = {
				{3, 2},
				{-2, 2}
		};
		
		VisitingPoints vPoints = new VisitingPoints();
		int res = vPoints.minTimeToVisitAllPoints(points2);
		System.out.println(res);
	}
	/*
	 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. 
	 * Your task is to find the minimum time in seconds to visit all points. 
	 * You can move according to the next rules: 
	 * 	1. In one second always you can either move vertically, horizontally by one unit or diagonally 
	 * 	- it means to move one unit vertically and one unit horizontally in one second
	 * 	2. You have to visit the points in the same order as they appear in the array.
	 */
    public int minTimeToVisitAllPoints(int[][] points) {
    	int minTime = 0;
    	
    	for (int i = 0; i < points.length - 1; i++) {
    		int[] pointOne = points[i];
    		int[] pointTwo = points[i + 1];

    		minTime += Math.max(Math.abs(pointTwo[0] - pointOne[0]), 
    				Math.abs(pointTwo[1] - pointOne[1]));
    	}
    	return minTime;
    }
}
