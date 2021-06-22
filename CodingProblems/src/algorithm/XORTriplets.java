package algorithm;

public class XORTriplets {

	public static void main(String[] args) {
		int[] arr = {2,3,1,6,7};
		
		countTriplets(arr);
	}
	
    public static int countTriplets(int[] arr) {
    	int n = arr.length + 1, res = 0;
    	int[] prefix = new int[n];
    	
    	for (int i = 1; i < n; i++) {
    		prefix[i] = arr[i - 1] ^ prefix[i - 1];
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j < n; j++) {
    			if (prefix[i] == prefix[j])
    				res += j - i - 1;
    		}
    	}
    	
    	return res;
    }
}
