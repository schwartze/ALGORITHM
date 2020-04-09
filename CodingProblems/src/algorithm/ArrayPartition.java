package algorithm;

import java.util.Arrays;

public class ArrayPartition {

	public static void main(String[] args) {
		ArrayPartition partition = new ArrayPartition();
		int[] nums = {1, 4, 3, 2};
		int result = partition.arrayPairSum(nums);
		System.out.println(result);
	}
	
	/*
	 * Given an array of 2n integers, your task is to group these integers 
	 * into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
	 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
	 */
	
    public int arrayPairSum(int[] nums) {
        
    	Arrays.sort(nums);
    	
    	int result = 0;
    	
    	// for (int i = 0; i < nums.length; i++) {
    	// 	if (i % 2 != 0)
    	// 		continue;
    	// 	result += nums[i];
    	// }
     
    	// another way of writing for statement which gives the same answer
    	for (int i = 0; i < nums.length; i += 2) {
    		result += nums[i];
    	 }
    	
    	return result;
    }
    
    
}
