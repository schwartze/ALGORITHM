package algorithm;

public class PrimeNumber {

	public static void main(String[] args) {
		int L = 10;
		int R = 15;
		
		PrimeNumber pNumber = new PrimeNumber();
		int res = pNumber.countPrimeSetBits(L, R);
		System.out.println(res);
	}
	
	// return the count of numbers range between L and R (inclusive) which has its bit count as prime number
	// note that 1 is not a prime number
    public int countPrimeSetBits(int L, int R) {
     
    	int ans = 0;
    	int target = L;
    	
    	while (target <= R) {
    		int bitCount = Integer.bitCount(target);
    		int n = 2;
    		boolean isPrime = true;
    		
    		while (n < bitCount) {

    			if (bitCount % n == 0) {
    				isPrime = false;
        			break;
    			}
        		n++;
    		}
    		
    		if (isPrime && bitCount != 1)
    			ans++;
    		target++;
    	}
    	
    	return ans;
    }
}
