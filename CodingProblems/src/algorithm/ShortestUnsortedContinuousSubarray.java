package algorithm;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		
		int result = sucs.findUnsortedSubarray3(nums);
		System.out.println(result);
	}
	/*
	 * Given an integer array, you need to find one continuous subarray 
	 * that if you only sort this subarray in ascending order, 
	 * then the whole array will be sorted in ascending order, too.
	 */
    public int findUnsortedSubarray(int[] nums) {
    	
    	int min, max;
    	min = nums[0];
    	max = nums[nums.length - 1];
    	
    	for (int i = 1, j = nums.length - 2; i < (nums.length / 2) - 1; i++, j--) {
    		
    		if (min < nums[i])
    			min = nums[i];
    		
    		if (max > nums[j]) 
    			max = nums[j];
    	}
    	
    	int begIdx = 0, 
    		endIdx = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == min)
    			begIdx = i;
    		
    		if (nums[i] == max)
    			endIdx = i;
    	}
    	
    	return (endIdx - begIdx + 1 == nums.length) ? 0 : endIdx - begIdx + 1;
    }
    
    public int findUnsortedSubarray2(int[] nums) {
    	
    	int[] temp = nums.clone();
    	
    	Arrays.sort(temp);
    	
    	int begIdx = nums.length, endIdx = 0;
    	
    	// nums = {2, 6, 4, 8, 10, 9, 15}
    	// temp = {2, 4, 6, 8, 9, 10, 15}
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		if (nums[i] != temp[i]) {
    			begIdx = Math.min(begIdx, i);
    			endIdx = Math.max(endIdx, i);
    		}
    	}
    	
    	return (endIdx - begIdx >= 0) ? endIdx - begIdx + 1 : 0;
    }
    
    // Brute Force
    public int findUnsortedSubarray3(int[] nums) {
    	
    	int start = nums.length; 
    	int end = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		for (int j = i + 1; j < nums.length - 1; j++) {
    			
    			if (nums[i] > nums[j]) {
    				start = Math.min(start, i);
    				end = Math.max(end, j);
    			}
    		}
    	}
    	
    	return end - start < 0 ? 0 : end - start + 1;
    }
}
