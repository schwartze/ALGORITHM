package algorithm;

public class PeakIndex {

	public static void main(String[] args) {
		int[] A = {0, 2, 1, 0};
		PeakIndex pIndex = new PeakIndex();
		int res = pIndex.peakIndexInMountainArray(A);
		System.out.println(res);
	}
	
    public int peakIndexInMountainArray(int[] A) {
    	int max = 0;
    	int res = 0;
    	
    	for (int i = 0; i < A.length; i++) {
    		max = Math.max(A[i], max);
    		
    		if (max == A[i])
    			res = i;
    	}
    	
    	return res;
    }
}
