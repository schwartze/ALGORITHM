package algorithm;

public class PerfectNumber {

	public static void main(String[] args) {
		PerfectNumber pNumber = new PerfectNumber();
		boolean result = pNumber.isPerfectNumber(28);
		System.out.println(result);
	}
	
    public boolean isPerfectNumber(int num) {
     
    	int result = 1;
    	
    	int n = (int)Math.sqrt(num);
    	
    	while (n > 1) {
    		
    		if (num % n == 0) {
    			result += n;
    			result += (num / n);
    		}
    		n--;
    	}
    	
    	return result == num ? true : false;
    }
}
