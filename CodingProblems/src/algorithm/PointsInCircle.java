package algorithm;

public class PointsInCircle {
	
	public static void main(String[] args) {
		int[][] points = { {1,3}, {3,3}, {5,3}, {2,2} };
		int[][] queries = { {2,3,1}, {4,3,1}, {1,1,2} };

		int[][] points2 = { {1,1}, {2,2}, {3,3}, {4,4}, {5, 5} };
		int[][] queries2 = { {1,2,2}, {2,2,2}, {4,3,2}, {4,3,3} };

		
		int[] res = countPoints(points2, queries2);
		for (int n : res)
			System.out.print(n + ", ");
	}

    public static int[] countPoints(int[][] points, int[][] queries) {
    	int[] res = new int[queries.length];
    	int i = 0;
    	
    	for (int[] query : queries) {
    		int minX = query[0] - query[2];
    		int maxX = query[0] + query[2];
    		int minY = query[1] - query[2];
    		int maxY = query[1] + query[2];
    		
    		for (int[] point : points) {
    			if (point[0] >= minX && point[0] <= maxX && point[1] >= minY && point[1] <= maxY) {
    				
    				if (point[0] == minX && point[1] == minY)
    					continue;
    				
    				if (point[0] == minX && point[1] == maxY)
    					continue;
    				
    				if (point[0] == maxX && point[1] == minY)
    					continue;

    				if (point[0] == maxX && point[1] == maxY)
    					continue;
    				res[i]++;
    			}
    		}
    		i++;
    	}
    	return res;
    }
}
