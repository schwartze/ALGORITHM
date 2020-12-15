package algorithm;

public class PatternDetector {

	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 2, 1, 3};
		int m = 2, k = 3;
		
		boolean res = containsPattern(arr, m, k);
		System.out.println(res);
	}
	
	// Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.
	// A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.
	// Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
    public static boolean containsPattern(int[] arr, int m, int k) {

    	for (int i = 0; i < arr.length && i + (m * k) <= arr.length; i++) {
    		boolean showPatterns = true;
    		int[] pattern = new int[m];

    		int j, l = 0, q = k - 1;
    		for (j = i; j < m + i; j++, l++) 
    			pattern[l] = arr[j];

    		int p = 0;
    		while (q-- > 0 && showPatterns) {
        		for (int x = 0; x < m; p++, x++) {
        			if (arr[p + m + i] != pattern[x]) {
        				showPatterns = false;
        				break;
        			}
        		}
    		}
    		if (showPatterns)
    			return true;
    	}
    	return false;
    }
}
