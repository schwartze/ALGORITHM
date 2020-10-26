package algorithm;

public class ReduceToZero {

	public static void main(String[] args) {
		int num = 123;
		int res = numberOfStepsToZero(num);
		System.out.println(res);
	}
	// Return the number of steps to reduce it to zero.
	// if the current number is even, it can be divided by 2
	// otherwise, it needs to be subtracted by 1 before division.
    public static int numberOfSteps (int num) {
    	int count = 0;
    	
    	while (num > 0) {
    		
    		if (num % 2 == 0) {
    			num /= 2;
    			count++;
    			continue;
    		}
    		num--;
    		count++;
    	}
    	
    	return count;
    }
    
    // Using Bitwise operation
    public static int numberOfStepsToZero(int num) {
    	int result = 0;
    	
    	while (num > 0) {
    		// AND operator: shows whether current num is odd or even (0 if even, 1 if add)
	    		// if even, add 1
	    		// if odd, add 2 (step 1: subtract / step2: divide it by 2)
    		// right shift by 1
    		result += (num & 1) == 0 ? 1 : 2;
    		num >>= 1;
    	}
    	
    	return result - 1;
    }
}
