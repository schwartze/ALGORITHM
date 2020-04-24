package algorithm;

public class RangeArrayII {

	public static void main(String[] args) {
		RangeArrayII range = new RangeArrayII();
		
		int[][] ops = { {2, 2}, 
						{3, 3},
						{4, 3},
						{3, 3},
						{2, 3} };
		
		int result = range.maxCount(3, 3, ops);
		System.out.println(result);
	}

	// need to count and return the number of maximum integers 
	// in the matrix after performing all the operations.
    public int maxCount(int m, int n, int[][] ops) {
     
    	for (int[] op : ops) {
    		
    		for (int i = 0; i < op.length - 1; i++) {
        		m = Math.min(m, op[i]);
        		n = Math.min(n, op[i + 1]);
    		}
    	}
    	return m * n;
    }
}
