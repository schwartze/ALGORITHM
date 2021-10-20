package algorithm;

public class MaximumXOR {
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 1, 3};
		int maximumBit = 2;
		
		int[] res = getMaximumXor(nums, maximumBit);
		for (int n : res)
			System.out.print(n + ", ");
	}

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
    	int[] res = new int[nums.length];
    	int k = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		int queryResult = 0;
    		res[i] = k;
    		
    		for (int j = 0; j < nums.length - i; j++) {
        		queryResult ^= nums[j];
    		}
    		queryResult ^= k;
    		k = queryResult;
    	}
    	
    	return res;
    }
}
