package algorithm;

public class SumOfSquare {

	public static void main(String[] args) {
		SumOfSquare square = new SumOfSquare();
		boolean result = square.judgeSquareSum2(5);
		System.out.println(result);
	}
	
    public boolean judgeSquareSum(int c) { 
    	int num = 1; 
    	
    	while (num <= c / 2) {
    		
    		if (isPerfectSquares(num)) {
        		long a = (long) Math.sqrt(num);
        		long b = (long) Math.sqrt(c - num);
        		
        		if ((a * a) + (b * b) == c)
        			return true;
    		}
    		num++;
    	}
    	return false;
    }
    
    private boolean isPerfectSquares(int n) {
    	
    	return Math.sqrt(n) - (int)Math.sqrt(n) == 0;
    }
    
    // #1. Brute Force 
    public boolean judgeSquareSum2(int c) {
    	
    	for (long a = 0; a * a <= c; a++) {
    		
    		for (long b = 0; b * b <= c; b++) {
    			
    			if ((a * a) + (b * b) == c)
    				return true;
    		}
    	}
    	return false;
    }
    
    // #2. sqrt function
    public boolean judgeSquareSum3(int c) {
    	
    	for (long a = 0; a * a <= c; a++) {
    		
    		double b = Math.sqrt(c - a * a);
    		
    		if (b - (int) b == 0)
    			return true;
    	}
    	
    	return false;
    }
}
