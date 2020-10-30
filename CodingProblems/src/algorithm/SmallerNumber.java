package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumber {

	public static void main(String[] args) {
		int[] nums = {8, 1, 2, 2, 3};
		smallerNumbersThanCurrent(nums);
		
		for (int n : nums)
			System.out.print(n + ", ");
	}
	// Given the array nums, for each nums[i] find out 
	// how many numbers in the array are smaller than it. 
	// That is, for each nums[i] you have to count the number of valid j's such that 
	// j != i and nums[j] < nums[i].
    public static int[] smallerNumbersThanCurrent(int[] nums) {
    	int[] sortedArr = nums.clone();
    	Arrays.sort(sortedArr);
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < sortedArr.length; i++) {
    		if (map.containsKey(sortedArr[i]))
    			continue;
    		map.put(sortedArr[i], i);
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = map.get(nums[i]);
    	}
    	return nums;
    }
}
