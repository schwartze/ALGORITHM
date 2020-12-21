package algorithm;

public class OddLength {

	public static void main(String[] args) {
		int[] arr = {10, 11, 12};
		
		int res = sumOddLengthSubarrays(arr);
		System.out.println(res);
	}
	
    public static int sumOddLengthSubarrays(int[] arr) {
    	int res = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		int j = i;
    		while (j < arr.length) {
    			for (int k = i; k <= j; k++) {
        			res += arr[k];
        		}
    			j += 2;
    		}
    	}
    	return res;
    }
}
