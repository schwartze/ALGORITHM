package algorithm;

public class ValidMountainArray {

	public static void main(String[] args) {
		int[] A = {0, 3, 2, 1};
		ValidMountainArray mountArray = new ValidMountainArray();
		boolean res = mountArray.validMountainArray(A);
		System.out.println(res);
	}
	
    public boolean validMountainArray(int[] A) {
    	
    	if (A.length < 4)
    		return false;
    	
    	int peak = Integer.MIN_VALUE;
    	int prev = A[0];
    	boolean isIncreasing = true;
    	
    	for (int n : A)
    		peak = Math.max(peak, n);
    	
    	for (int i = 1; i < A.length; i++) {
    		
    		if (isIncreasing) {
    			if (A[i] <= prev)
    				return false;
    		} else {
    			if (A[i] >= prev)
    				return false;
    		}
    		prev = A[i];
    		
    		if (A[i] == peak)
    			isIncreasing = false;
    	}
    	
    	return true;
    }
}
