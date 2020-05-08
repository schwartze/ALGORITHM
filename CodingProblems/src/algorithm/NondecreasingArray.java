package algorithm;

public class NondecreasingArray {

	public static void main(String[] args) {
		int[] nums = {3, 4, 2, 3};
		
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
    		}
			if (result)
				return result;
    	}
    	return false;
    }
    
    public boolean checkPossibility2(int[] nums) {
        int p = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                if (p != -1) return false;
                else p = i;
            }
        }
        return (p == -1 ||   // no reversed pair
                p == 1 || p == nums.length - 1 ||  // reversed pair is first or last element
                nums[p - 2] <= nums[p] || nums[p - 1] <= nums[p + 1]); // normal case range [p-2 --> p+1] all valid
    }
}
