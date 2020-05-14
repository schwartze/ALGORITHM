package algorithm;

public class IncreasingSubarray {

	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 4, 7};
		IncreasingSubarray subarray = new IncreasingSubarray();
		int result = subarray.findLengthOfCIS(nums);
		System.out.println(result);
	}
	
	// CIS : Continuous Increasing Subarray
	public int findLengthOfCIS(int[] nums) {
		
		int res = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = i + 1; j < nums.length - 1; j++) {
				
				if (nums[j] > nums[j + 1]) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		
		return res;
	}
}
