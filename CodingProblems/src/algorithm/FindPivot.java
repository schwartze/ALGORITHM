package algorithm;

public class FindPivot {
	
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 5, 6};
		int[] nums2 = {1, 2, 3};
		int[] nums3 = {-1, -1, -1, -1, -1, 0};
		
		FindPivot pivot = new FindPivot();
		int n = pivot.pivotIndex(nums3);
		System.out.println(n);
	}

	// pivot index is the index whose sum of all left elements of the index is the 
	// same as the sum of right elements 
    public int pivotIndex(int[] nums) {
     
    	int left = 0;
    	for (int i = 0; i < nums.length; i++) {
    		int idx = i;
    		int right = 0;
    		
    		for (int j = idx + 1; j < nums.length; j++) {
    			right += nums[j];
    		}
    		
    		if (left == right)
    			return idx;

    		left += nums[i];
    	}
    	
    	return -1;
    }
    
    public int pivotIndex2(int[] nums) {
        
    	int sum = 0, leftSum = 0;
    	
    	for (int n : nums)
    		sum += n;
    	
    	for (int i = 0; i < nums.length; i++) {

    		if (leftSum == sum - leftSum - nums[i])
    			return i;
    		leftSum += nums[i];
    	}
    	
    	return -1;
    }
}
