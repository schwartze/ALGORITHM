package algorithm;

public class RectangleCount {

	public static void main(String[] args) {
		int[][] rectangles = {
				{5, 8},
				{3, 9},
				{5, 12},
				{16, 5}
		};
		
		int[][] rectangles2 = {
				{2, 3},
				{3, 7},
				{4, 3},
				{3, 7}
		};
		
		int res = countGoodRectangles(rectangles2);
		System.out.println(res);
		
	}
	
    public static int countGoodRectangles(int[][] rectangles) {
    	int result = 0, maxLength = 0;
    	
    	for (int i = 0; i < rectangles.length; i++) {
    		int maxWidth = Math.min(rectangles[i][0], rectangles[i][1]);

    		if (maxWidth == maxLength)
    			result++;

    		if (maxWidth > maxLength) {
    			maxLength = maxWidth;
    			result = 1;
    		}
    	}
    	return result;
    }
}
