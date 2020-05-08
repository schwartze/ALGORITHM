package algorithm;

public class NondecreasingArray {

	public static void main(String[] args) {
		int[] nums = {4, 2, 3};
		
		NondecreasingArray nondecreasing = new NondecreasingArray();
		boolean result = nondecreasing.checkPossibility(nums);
		System.out.println(result);
	}
	// make given array into an increasing array by changing at most 1 integer
    public boolean checkPossibility(int[] nums) {
    	
    	for (int n : nums) {
    		boolean result = true;
        	
    		for (int i = 0; i < nums.length - 1; i++) {
    			
    			if (nums[i] == n) 
    				continue;
    				
    			if (nums[i + 1] == n && (i + 1 != nums.length - 1))
    				result = nums[i] <= nums[i + 2];
    			else 
    				result = nums[i] <= nums[i + 1];

    			if (result)
    				return result;
    		}
    	}
    	return false;
    }
}
