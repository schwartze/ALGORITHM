package algorithm;

import java.math.BigInteger;

public class PrimeArrangement {

	public static void main(String[] args) {
		int n = 100;
		PrimeArrangement pArr = new PrimeArrangement();
		System.out.println(pArr.numPrimeArrangements(n));
		
	}
	
	private BigInteger M = new BigInteger("1000000007");
	
	// find the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed)
	// since the answer may be large, return the answer in modulo 10^9 + 7
    public int numPrimeArrangements(int n) {
    	int primeCount = 0;
    	int num = 1;
    	
    	while (num < n + 1) {
    		if (isPrime(num))
    			primeCount++;
    		num++;
    	}
    	
    	BigInteger primeFact = getFactorial(primeCount);
    	BigInteger nonPrimeFact = getFactorial(n - primeCount);
    	
    	return Integer.parseInt(primeFact.multiply(nonPrimeFact).mod(M).toString());
    }
    
    private BigInteger getFactorial(int n) {
    	BigInteger res = new BigInteger(Integer.toString(n));
    	
    	while (--n > 0) {
        	BigInteger num = new BigInteger(Integer.toString(n));
    		res = res.multiply(num).mod(M);
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
