package algorithm;

public class MaximumXOR {
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 1, 3};
		int maximumBit = 2;
		
		int[] nums2 = {2, 3, 4, 7};
		int maximumBit2 = 3;
		
		int[] nums3 = {0, 1, 2, 2, 5, 7};
		int maximumBit3 = 3;
		
		int[] res = getMaximumXor(nums3, maximumBit3);
		for (int n : res)
			System.out.print(n + ", ");
	}

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
    	int[] res = new int[nums.length];
    	int max = (int)Math.pow(2, maximumBit) - 1;
    	int prevAccumulated = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		int query = prevAccumulated ^ nums[i];
    		res[nums.length - 1 - i] = query ^ max;
    		prevAccumulated ^= nums[i];
    	}
    	
    	return res;
    }

}
