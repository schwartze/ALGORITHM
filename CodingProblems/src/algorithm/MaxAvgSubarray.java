package algorithm;

public class MaxAvgSubarray {

	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;

		MaxAvgSubarray maxAvg = new MaxAvgSubarray();
		double res = maxAvg.findMaxAverage(nums, k);
		System.out.println(res);
	}
	// given an array of n integers, 
	// find the contiguous subarray of given length k 
	// that has the maximum avg value.
    public double findMaxAverage(int[] nums, int k) {
    	
    	int i = 0; 
    	double max = Double.MIN_VALUE;
    	
    	while (i + k <= nums.length) {
    		int sum = 0;
    		
    		for (int j = i; j < i + k; j++) {
    			sum += nums[j];
    		}
    		
    		if (sum / k > max)
    			max = (sum * 1.0 / k * 1.0);
    		i++;
    	}
    	
    	return max;
    }
}
