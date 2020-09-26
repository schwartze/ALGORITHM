package algorithm;

public class PrimeArrangement {

	public static void main(String[] args) {
		int n = 5;
		PrimeArrangement pArr = new PrimeArrangement();
		 System.out.println(pArr.numPrimeArrangements(n));
	}
	
	private long M = 1000000007;
	
	// find the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed)
	// since the answer may be large, return the answer in modulo 10^9 + 7
    public int numPrimeArrangements(int n) {
    	if (n < 2)
    		return 1;
    	int primeCount = 0;
    	int num = 1;
    	
    	while (num < n + 1) {
    		if (isPrime(num))
    			primeCount++;
    		num++;
    	}
    	
    	long primeFact = getFactorial(primeCount);
    	long nonPrimeFact = getFactorial(n - primeCount);
    	
    	return (int)((primeFact * nonPrimeFact) % M);
    }
    
    private long getFactorial(int n) {
    	long res = n;
    	
    	while (--n > 0) {
        	long num = n;
        	res = (res * num) % M;
    	}
    	return res;
    }
    
    private boolean isPrime(int n) {
    	int count = 0;
    	int i = 1;
    	
    	while (n + 1 > i) {
    		
    		if (n % i == 0)
    			count++;
    		if (count > 2)
    			break;
    		i++;
    	}
    	return count == 2;
    }
}
