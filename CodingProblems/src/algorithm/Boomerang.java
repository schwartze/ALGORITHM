package algorithm;

public class Boomerang {

	public static void main(String[] args) {
		int[][] points = {
				{1, 1},
				{2, 3},
				{3, 2}};
		
		int[][] points2 = {
				{0, 1},
				{1, 1},
				{2, 1}};
		
		Boomerang boomerang = new Boomerang();
		boolean res = boomerang.isBoomerang(points2);
		System.out.println(res);
	}
	
	// The three given points are boomerang if and only if 
	// 1. the points are distinct 
	// 2. they are not in a straight line
    public boolean isBoomerang(int[][] points) {
    	// Method 1: Calculate the slope of AB and AC 
    	// K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
    	// K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
    	
    	// Method 2: Calculate the area of ABC
    	// 0.5 * (i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - 
    	// j[0] * i[1] - k[0] * j[1] - i[0] * k[1]);
    	
    	return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != 
    			(points[0][1] - points[1][1]) * (points[0][0] - points[2][0]) ;
    }
}
