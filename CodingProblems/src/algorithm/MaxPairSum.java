package algorithm;

import java.util.Arrays;

public class MaxPairSum {

	public static void main(String[] args) {
		int[] nums = { 3,5,2,3 };
		int[] nums2 = { 3,5,4,2,4,6 };
		
		int res = minPairSum( nums2 );
		System.out.println( res );
	}
	
    public static int minPairSum(int[] nums) {
    	int max = 0;
    	Arrays.sort( nums );

    	for (int i = 0; i < nums.length / 2; i++) {
    		max = Math.max( max, nums[nums.length - i - 1] + nums[i] );
    	}
    	return max;
    }
}
