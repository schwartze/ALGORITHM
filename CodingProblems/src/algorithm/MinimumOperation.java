package algorithm;

public class MinimumOperation {

    public int minOperations(int[] nums) {
        int res = 0;
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] > nums[i])
				continue;
			
			res += nums[i] + 1 - nums[i + 1];
			nums[i + 1] = nums[i] + 1;
		}
		
		return res;
    }
}
