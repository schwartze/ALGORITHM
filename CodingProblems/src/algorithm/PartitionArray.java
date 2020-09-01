package algorithm;

public class PartitionArray {

	public static void main(String[] args) {
		int[] A = {10,-10,10,-10,10,-10,10,-10};
		PartitionArray pArray = new PartitionArray();
		boolean res = pArray.canThreePartsEqualSum(A);
		System.out.println(res);
	}
	/*
	 * Given an array A of integers, return true if and only if 
	 * we can partition the array into three non-empty parts with equal sums.
	 * Formally, we can partition the array if we can find indexes i+1 < j with 
	 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + 
	 * A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
	 */
    public boolean canThreePartsEqualSum(int[] A) {
    	int totalSum = 0, partCount = 0, sum = 0;
    	
    	for (int n : A)
    		totalSum += n;
    	
    	for (int i = 0; i < A.length; i++) {
    		sum += A[i];
    		
    		if (sum == totalSum / 3) {
    			sum = 0;
    			partCount++;
    			
    			if (partCount >= 3)
    				return true;
    		}
    	}
    	return false;
    }
}
