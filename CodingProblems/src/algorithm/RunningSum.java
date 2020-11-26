package algorithm;

public class RunningSum {

	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 10, 1};
		runningSum(nums);
		
		for (int n : nums)
			System.out.print(n + ", ");
	}
	
    public static int[] runningSum(int[] nums) {
    	
    	for (int i = 1; i < nums.length; i++) 
    		nums[i] += nums[i - 1];
    	
    	return nums;
    }
}
