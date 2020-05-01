package algorithm;

public class SumOfSquare {

	public static void main(String[] args) {
		SumOfSquare square = new SumOfSquare();
		boolean result = square.judgeSquareSum(5);
		System.out.println(result);
	}
	
    public boolean judgeSquareSum(int c) { 
    	int num = 0; 
    	
    	while (num <= c / 2) {
    		
    		if (isPerfectSquares(num)) {
        		int a = (int) Math.sqrt(num);
        		int b = (int) Math.sqrt(c - num);
        		
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
}
