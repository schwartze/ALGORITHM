package algorithm;

public class PositiveSum {

	public static void main(String[] args) {
		int[] nums = {-3, 2, -3, 4, 2};
		
		int res = minStartValue2(nums);
		System.out.println(res);
	}
	// Given an array of integers nums, you start with an initial positive value startValue.
	// In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
	// Return the minimum positive value of startValue such that the step by step sum is never less than 1.
    public static int minStartValue(int[] nums) {
    	int sum = 0, minSum = 0;
    	
    	for (int n : nums) {
    		sum += n;
    		minSum = Math.min(minSum, sum);
    	}
    	
    	return 1 - minSum;
    }
    
    public static int minStartValue2(int[] nums) {
        if( nums == null || nums.length == 0) return 1;

        int current = 1, startVal = 1;

        for( int i = 0; i < nums.length; i++){
            current += nums[i];

            while( current < 1){
                current += 1;
                startVal += 1;
            }
        }
        return startVal;
    }
}
