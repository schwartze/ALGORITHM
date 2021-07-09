package algorithm;

public class FibonacciNumber {

	public static void main(String[] args) {
		FibonacciNumber fNum = new FibonacciNumber();
		int result = fNum.fibonacci(3);
		System.out.println(result);
	}
	
	// Fibonacci numbers is fibonacci sequence
	// that is, each number is the sum of the two proceeding ones
	// F(N) = F(N - 1) + F(N - 2), for N > 1

	// #1. recursive method
	public int fib(int N) {
    
		if (N <= 1)
			return N;
		
		return fib(N - 1) + fib(N - 2);
    }


	// #1. recursive method review
    public int fibonacci(int N) {
    	if (N <= 1)
    		return N;
    	
    	return fibonacci(N - 1) + fibonacci(N - 2);
    }

	// #2. iterative method
	public int fibNum(int N) {
		
		if (N <= 1)
			return N;
		
		int a = 0;
		int b = 1;
		
		while (N > 1) {
			int sum = a + b;
			a = b;
			b = sum;
			N--;
		}
		
		return b;
	}
}
