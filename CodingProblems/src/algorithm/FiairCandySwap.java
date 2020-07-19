package algorithm;

public class FiairCandySwap {

	public static void main(String[] args) {
		int[] A = {1, 2};
		int[] B = {2, 3};
		
		FiairCandySwap candySwap = new FiairCandySwap();
		int[] res = candySwap.fairCandySwap(A, B);
		
		for (int n : res) 
			System.out.println(n);
	}
	
	/* 
	Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
	Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
	Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
	*/
	
    public int[] fairCandySwap(int[] A, int[] B) {
     
    	int aSize = getTotal(A);
    	int bSize = getTotal(B);
    	int[] res = new int[2];
    	
    	for (int i = 0; i < A.length; i++) {
    		int tempASize = aSize - A[i];
    		
    		for (int j = 0; j < B.length; j++) {
        		int tempBSize = bSize - B[j];
    			tempASize += B[j];
    			tempBSize += A[i];
    			
    			if (tempASize == tempBSize) {
    				res[0] = A[i];
    				res[1] = B[j];
    			}
    		}
    	}
    	return res;
    }
    
    private int getTotal(int[] candySizes) {
    	int totalSize = 0;
    	
    	for (int size : candySizes) 
    		totalSize += size;
    	
    	return totalSize;
    }
	
}
