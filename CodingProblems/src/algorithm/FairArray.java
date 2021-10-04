package algorithm;

public class FairArray {

	public static void main(String[] args) {
		int[] nums = {2, 1, 6, 4};
		int[] nums2 = {1, 1, 1};
		int[] nums3 = {1, 2, 3};
		
		int fairCount = waysToMakeFair(nums3);
		System.out.println(fairCount);
	}
	
    public static int waysToMakeFair(int[] nums) {
        int count = 0;
        
    	for (int i = 0; i < nums.length; i++) {
    		int evenSum = 0, oddSum = 0;
    		
    		for (int j = 0, k = 0; j < nums.length; j++) {
    			
    			if (i == j) 
    				continue;
    			
    			if (k % 2 == 0)
    				evenSum += nums[j];
    			else 
    				oddSum += nums[j];
    			
    			k++;
    		}

    		if (evenSum == oddSum)
    			count++;
    	}
    	
    	return count;
    }
}
