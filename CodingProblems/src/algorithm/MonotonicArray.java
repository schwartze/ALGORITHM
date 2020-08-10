package algorithm;

public class MonotonicArray {

	public static void main(String[] args) {
		int[] A = {1, 2, 4, 5};
		MonotonicArray mArray = new MonotonicArray();
		boolean res = mArray.isMonotonic(A);
		System.out.println(res);
	}
	
	// An array is monotonic if it is either monotone increasing or decreasing
    public boolean isMonotonic(int[] A) {
    	
    	boolean isIncreasing = true;
    	
    	if (A[0] > A[A.length - 1])
    		isIncreasing = false;
    	
    	for (int i = 0; i < A.length - 1; i++) {
    		
    		if (isIncreasing) {
    			if (A[i] > A[i + 1])
    			return false;
    		} else {
    			if (A[i] < A[i + 1])
    			return false;
    		}
    	}

    	return true;
    }
}
